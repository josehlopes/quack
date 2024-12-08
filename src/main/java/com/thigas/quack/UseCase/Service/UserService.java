package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Factory.Interface.UserFactory;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.PayloadUtil;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
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
                encodedCpf, LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
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

    public ResponseWrapper<GenericResponseModel> deleteUser(Integer id) {
        try {
            if (!userDsGateway.existsById(id)) {
                throw new NoSuchElementException("User not found");
            }
            userDsGateway.deleteUserById(id);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("User deleted"), 200);
        } catch (Exception e) {
            logger.error("Error deleting user with ID: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error deleting user"), 500);
        }
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
}