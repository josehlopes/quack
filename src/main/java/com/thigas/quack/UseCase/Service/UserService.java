// src/main/java/com/thigas/quack/UseCase/Service/UserService.java
package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserService implements UserInputBoundary {

    private final UserDsGateway userDsGateway;
    private final UserPresenter userPresenter;
    private final UserFactory userFactory;
    private final TokenGateway tokenGateway;
    private final EncoderInputBoundary encoderInputBoundary;
    private final EncoderGateway encoderGateway;
    private final UserMapper userMapper;

    public ResponseWrapper<GenericResponseModel> register(UserRegisterRequestModel userRequest) {
        if (userDsGateway.findByEmail(userRequest.email())) {
            return userPresenter.prepareFailView( new GenericResponseModel("Email already in use"), 409);
        }

        String encodedPassword = encoderInputBoundary.encode(userRequest.password());
        String encodedCpf = encoderInputBoundary.encode(userRequest.cpf());

        User user = userFactory.create(
                userRequest.name(), userRequest.surname(), userRequest.phone(), userRequest.email(), encodedPassword,
                encodedCpf, LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
        );

        UserDsRequestModel userDsModel = userMapper.toDsModel(user);

        userDsGateway.save(userDsModel);
        String token = tokenGateway.generateToken(user.getEmail());
        return userPresenter.prepareSuccessView(new GenericResponseModel(token), 201);
    }

    @Override
    public ResponseWrapper<UserLoginResponseModel> login(UserLoginRequestModel userRequest) {
        Optional<UserDsRequestModel> user = userDsGateway.getByEmail(userRequest.email());
        if (user.isEmpty()) {
            return userPresenter.prepareFailView(new GenericResponseModel("User not found"), 404);
        }

        if (!encoderGateway.match(userRequest.password(), user.get().password())) {
            return userPresenter.prepareFailView(new GenericResponseModel("Invalid password"), 401);
        }

        String token = tokenGateway.generateToken(user.get().email());
        UserLoginResponseModel responseModel = new UserLoginResponseModel(user.get().id(), token);
        return userPresenter.prepareSuccessView(responseModel, 200);
    }
    public Iterable<UserDsRequestModel> getAll() {
        Iterable<UserDsRequestModel> users = userDsGateway.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Boolean update(UserDsRequestModel userDTO) {
        UserDsRequestModel existingUser = userDsGateway.getById(userDTO.id())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        UserDsRequestModel updatedUser = new UserDsRequestModel(
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

        userDsGateway.update(updatedUser);
        return true;
    }

    public Boolean delete(Integer id) {
        if (!userDsGateway.findById(id)) {
            throw new NoSuchElementException("User not found");
        }
        userDsGateway.deleteById(id);
        return true;
    }

    public Optional<UserDsRequestModel> findByEmail(String email) {
        return userDsGateway.getByEmail(email);
    }

    public Optional<UserDsRequestModel> findByUsername(String username) {
        return userDsGateway.getByUsername(username);
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.findByEmail(email) || userDsGateway.findByUsername(username);
    }

    public Boolean existsById(int userId) {
        return userDsGateway.findById(userId);
    }
}