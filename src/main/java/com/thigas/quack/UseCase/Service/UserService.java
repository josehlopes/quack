package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Factory.Interface.UserFactory;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.PayloadUtil;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserService implements UserInputBoundary {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserDsGateway userDsGateway;
    private final GenericPresenter genericPresenter;
    private final UserFactory userFactory;
    private final TokenGateway tokenGateway;
    private final EncoderInputBoundary encoderInputBoundary;
    private final EncoderGateway encoderGateway;
    private final UserMapper userMapper;
    private final StatisticsService statisticsService;
    private final AddressService addressService;
    private final AddressDsGateway addressDsGateway;
    
    public ResponseWrapper<GenericResponseModel> createUser(UserRegisterRequestModel userRequest) {
        try {
            if (isEmailInUse(userRequest.email())) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Email already in use"), 409);
            }
            
            User user = createUserFromRequest(userRequest);
            saveUser(user);
            
            String token = generateToken(user.getEmail());
            Map<String, Object> payload = PayloadUtil.createRegisterPayload(token);
            
            createInitialUserStatistics(user.getEmail());
            
            return genericPresenter.prepareSuccessView(new GenericResponseModel("User registered successfully", payload), 201);
        } catch (Exception e) {
            logger.error("Error creating user", e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error creating user"), 500);
        }
    }

    private Boolean isEmailInUse(String email) {
        return userDsGateway.existsByEmail(email);
    }
    
    private User createUserFromRequest(UserRegisterRequestModel userRequest) {
        String encodedPassword = encoderInputBoundary.encodePassword(userRequest.password());
        String encodedCpf = encoderInputBoundary.encodePassword(userRequest.cpf());
        
        return userFactory.create(
                userRequest.name(), userRequest.surname(), userRequest.phone(), userRequest.email(), encodedPassword,
                encodedCpf, LocalDate.parse(userRequest.bornDate())
        );
    }

    private void saveUser(User user) {
        try {
            UserRequestModel userDsModel = userMapper.toDsModel(user);
            userDsGateway.saveUser(userDsModel);
        } catch (Exception e) {
            logger.error("Error saving user", e);
            throw new RuntimeException("Error saving user");
        }
    }

    private void createInitialUserStatistics(String email) {
        try {
            Optional<UserRequestModel> user = userDsGateway.getByEmail(email);
            statisticsService.create(user.get().id());
        } catch (Exception e) {
            logger.error("Error creating initial user statistics", e);
            throw new RuntimeException("Error creating initial user statistics");
        }
    }

    private String generateToken(String email) {
        return tokenGateway.generateToken(email);
    }

    public Optional<UserRequestModel> findByEmail(String email) {
        try {
            return userDsGateway.getByEmail(email);
        } catch (Exception e) {
            logger.error("Error finding user by email: {}", email, e);
            return Optional.empty();
        }
    }

    public Optional<UserRequestModel> findByUsername(String username) {
        try {
            return userDsGateway.getByUsername(username);
        } catch (Exception e) {
            logger.error("Error finding user by username: {}", username, e);
            return Optional.empty();
        }
    }

    public Boolean existsByEmailOrUsername(String email, String username) {
        try {
            return userDsGateway.existsByEmail(email) || userDsGateway.existsByUsername(username);
        } catch (Exception e) {
            logger.error("Error checking if email or username exists", e);
            return false;
        }
    }

    public Boolean existsById(int userId) {
        try {
            return userDsGateway.existsById(userId);
        } catch (Exception e) {
            logger.error("Error checking if user exists by ID: {}", userId, e);
            return false;
        }
    }

    public Optional<UserRequestModel> getById(int id) {
        try {
            return userDsGateway.getUserById(id);
        } catch (Exception e) {
            logger.error("Error getting user by ID: {}", id, e);
            return Optional.empty();
        }
    }

    public Iterable<UserRequestModel> getAll() {
        try {
            Iterable<UserRequestModel> users = userDsGateway.getAllUsers();
            return StreamSupport.stream(users.spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all users", e);
            return Collections.emptyList();
        }
    }

    public ResponseWrapper<GenericResponseModel> updateUser(UserRequestModel userDTO) {
        try {
            UserRequestModel existingUser = userDsGateway.getUserById(userDTO.id())
                    .orElseThrow(() -> new NoSuchElementException("User not found"));

            UserRequestModel updatedUser = updateUserDetails(userDTO, existingUser);

            userDsGateway.updateUser(updatedUser);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("User updated"), 204);
        } catch (Exception e) {
            logger.error("Error updating user with ID: {}", userDTO.id(), e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error updating user"), 500);
        }
    }

    private UserRequestModel updateUserDetails(UserRequestModel userDTO, UserRequestModel existingUser) {
        return new UserRequestModel(
                userDTO.id(),
                userDTO.name() != null ? userDTO.name() : existingUser.name(),
                userDTO.surname() != null ? userDTO.surname() : existingUser.surname(),
                userDTO.fullName() != null ? userDTO.fullName() : existingUser.fullName(),
                userDTO.username() != null ? userDTO.username() : existingUser.username(),
                userDTO.phone() != null ? userDTO.phone() : existingUser.phone(),
                userDTO.email() != null ? userDTO.email() : existingUser.email(),
                userDTO.password() != null ? userDTO.password() : existingUser.password(),
                userDTO.cpf() != null ? userDTO.cpf() : existingUser.cpf(),
                userDTO.bornDate() != null ? userDTO.bornDate() : existingUser.bornDate(),
                existingUser.registerOn(),
                userDTO.imagePath() != null ? userDTO.imagePath() : existingUser.imagePath(),
                userDTO.isActive() != null ? userDTO.isActive() : existingUser.isActive()
        );
    }
    
    @Override
    public ResponseWrapper<GenericResponseModel> login(UserLoginRequestModel userRequest) {
        try {
            Optional<UserRequestModel> user = userDsGateway.getByEmail(userRequest.email());
            if (user.isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("User not found"), 404);
            }

            if (!encoderGateway.matchPassword(userRequest.password(), user.get().password())) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Invalid password"), 401);
            }

            String token = generateToken(user.get().email());

            Map<String, Object> payload = PayloadUtil.createLoginPayload(user.get().id(), token);

            return genericPresenter.prepareSuccessView(new GenericResponseModel("Login successfully", payload), 200);
        } catch (Exception e) {
            logger.error("Error logging in user with email: {}", userRequest.email(), e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error logging in user"), 500);
        }
    }

    public StatisticsRequestModel getStatistics(Integer userId) {
        try {
            return statisticsService.getByUserId(userId).get();
        } catch (Exception e) {
            logger.error("Error getting statistics for user ID: {}", userId, e);
            throw new RuntimeException("Error getting statistics");
        }
    }

    public ResponseWrapper<GenericResponseModel> deactivateUser(Integer userId) {
        try {
            logger.info("Attempting to deactivate user with ID: {}", userId);

            boolean isDeactivated = userDsGateway.deactivateUserById(userId);
            if (!isDeactivated) {
                throw new NoSuchElementException("User not found");
            }

            logger.info("Deactivating addresses for user with ID: {}", userId);
            Iterable<AddressInfoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
            if (addresses == null || !addresses.iterator().hasNext()) {
                logger.warn("No addresses found for user with ID: {}", userId);
            } else {
                for (AddressInfoResponseModel address : addresses) {
                    try {
                        addressService.deactivateAddressByUserId(userId, address.id());
                        logger.info("Address with ID {} deactivated for user with ID {}", address.id(), userId);
                    } catch (Exception e) {
                        logger.error("Error deactivating address with ID {} for user with ID {}", address.id(), userId, e);
                    }
                }
            }

            try {
                logger.info("Deactivating statistics for user with ID: {}", userId);
                statisticsService.deactivateStatisticsByUserId(userId);
                logger.info("Statistics deactivated for user with ID: {}", userId);
            } catch (Exception e) {
                logger.error("Error deactivating statistics for user with ID: {}", userId, e);
            }

            Map<String, Object> payload = PayloadUtil.createAddressPayload("User and associated addresses deactivated successfully");
            return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 200);

        } catch (NoSuchElementException e) {
            logger.error("Error deactivating user. User not found with ID: {}", userId, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("User not found"), 404);

        } catch (Exception e) {
            logger.error("Error deactivating user with ID: {}", userId, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error deactivating user and addresses"), 500);
        }
    }
    

@Override
public ResponseWrapper<GenericResponseModel> saveProfileImage(Integer userId, ProfileImageRequestModel file) throws IOException {
    UserRequestModel existingUser = userDsGateway.getUserById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found"));

    String baseDir = System.getProperty("user.dir");
    String uploadDir = Paths.get(baseDir, "src/main/resources/static/images/users/").toString();

    String sanitizedFileName = file.originalFileName().replaceAll("[^a-zA-Z0-9._-]", "_");
    String shortUUID = UUID.randomUUID().toString().substring(0, 8);
    String fileExtension = getFileExtension(file.originalFileName());
    String fileName = shortUUID + "_" + md5Hash(sanitizedFileName) + fileExtension;

    Path path = Paths.get(uploadDir, fileName);

    Files.createDirectories(path.getParent());

    logger.info("Saving file to: " + path.toString());

    try (InputStream inputStream = new ByteArrayInputStream(file.content())) {
        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
        logger.info("File saved successfully at: " + path.toString());
    } catch (IOException e) {
        logger.error("Error saving file: " + e.getMessage());
        e.printStackTrace();
        throw e;
    }

    if (!Files.exists(path)) {
        logger.error("File not found after saving: " + path.toString());
        throw new IOException("File not found after saving");
    }
    logger.info("File exists? " + Files.exists(path));
    logger.info("File size: " + Files.size(path));

    UserRequestModel updatedUser = new UserRequestModel(
            existingUser.id(),
            existingUser.name(),
            existingUser.surname(),
            existingUser.fullName(),
            existingUser.username(),
            existingUser.phone(),
            existingUser.email(),
            existingUser.password(),
            existingUser.cpf(),
            existingUser.bornDate(),
            existingUser.registerOn(),
            path.toString(),
            existingUser.isActive()
    );

    userDsGateway.updateUser(updatedUser);

    // Retornar sucesso
    return genericPresenter.prepareSuccessView(new GenericResponseModel("File saved and user updated successfully"), 200);
}

private String md5Hash(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("MD5 algorithm not found", e);
    }
}

private String getFileExtension(String fileName) {
    int lastIndexOfDot = fileName.lastIndexOf(".");
    if (lastIndexOfDot == -1) {
        return ""; // No extension found
    }
    return fileName.substring(lastIndexOfDot);
}

    
    
}