package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Factory.Interface.UserFactory;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.PayloadUtil;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserService implements UserInputBoundary {

    private final UserDsGateway userDsGateway;
    private final GenericPresenter genericPresenter;
    private final UserFactory userFactory;
    private final TokenGateway tokenGateway;
    private final EncoderInputBoundary encoderInputBoundary;
    private final EncoderGateway encoderGateway;
    private final UserMapper userMapper;
    private final StatisticsService statisticsService;


    public ResponseWrapper<GenericResponseModel> create(UserRegisterRequestModel userRequest) {
        if (isEmailInUse(userRequest.email())) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Email already in use"), 409);
        }

        User user = createUser(userRequest);
        saveUser(user);

        String token = generateToken(user.getEmail());
        Map<String, Object> payload = PayloadUtil.createRegisterPayload(token);

        createInitialUserStatistics(user.getEmail());

        return genericPresenter.prepareSuccessView(new GenericResponseModel("User registered successfully", payload), 201);
    }

    private Boolean isEmailInUse(String email) {
        return userDsGateway.findByEmail(email);
    }

    private User createUser(UserRegisterRequestModel userRequest) {
        String encodedPassword = encoderInputBoundary.encode(userRequest.password());
        String encodedCpf = encoderInputBoundary.encode(userRequest.cpf());

        return userFactory.create(
                userRequest.name(), userRequest.surname(), userRequest.phone(), userRequest.email(), encodedPassword,
                encodedCpf, LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
        );

    }

    private void saveUser(User user) {
        UserRequestModel userDsModel = userMapper.toDsModel(user);
        userDsGateway.save(userDsModel);
    }

    private void createInitialUserStatistics(String email) {
        Optional<UserRequestModel> user = userDsGateway.getByEmail(email);
        statisticsService.create(user.get().id());
    }

    private String generateToken(String email) {
        return tokenGateway.generateToken(email);
    }

    public Optional<UserRequestModel> findByEmail(String email) {
        return userDsGateway.getByEmail(email);
    }

    public Optional<UserRequestModel> findByUsername(String username) {
        return userDsGateway.getByUsername(username);
    }

    public Boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.findByEmail(email) || userDsGateway.findByUsername(username);
    }

    public Boolean existsById(int userId) {
        return userDsGateway.findById(userId);
    }

    public Optional<UserRequestModel> getById(int id) {
        return userDsGateway.getById(id);
    }

    public Iterable<UserRequestModel> getAll() {
        Iterable<UserRequestModel> users = userDsGateway.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public ResponseWrapper<GenericResponseModel> update(UserRequestModel userDTO) {
        UserRequestModel existingUser = userDsGateway.getById(userDTO.id())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        UserRequestModel updatedUser = updateUserDetails(userDTO, existingUser);

        userDsGateway.update(updatedUser);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("User updated"), 204);
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

    public ResponseWrapper<GenericResponseModel> delete(Integer id) {
        if (!userDsGateway.findById(id)) {
            throw new NoSuchElementException("User not found");
        }
        userDsGateway.deleteById(id);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("User deleted"), 200);
    }

    @Override
    public ResponseWrapper<GenericResponseModel> login(UserLoginRequestModel userRequest) {
        Optional<UserRequestModel> user = userDsGateway.getByEmail(userRequest.email());
        if (user.isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("User not found"), 404);
        }

        if (!encoderGateway.match(userRequest.password(), user.get().password())) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Invalid password"), 401);
        }

        String token = generateToken(user.get().email());

        Map<String, Object> payload = PayloadUtil.createLoginPayload(user.get().id(), token);

        return genericPresenter.prepareSuccessView(new GenericResponseModel("Login successfully", payload), 200);
    }
}