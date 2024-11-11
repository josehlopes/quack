package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserService implements UserInputBoundary {

    private final UserDsGateway userDsGateway;
    private final UserPresenter userPresenter;
    private final UserFactory userFactory;

    @Override
    public UserLoginDtoResponseModel create(UserRegisterDtoRequestModel userRequest) {
        if (userDsGateway.existsByEmail(userRequest.email())) {
            return userPresenter.prepareFailView("User already exists");
        }
        User user = userFactory.create(userRequest.name(), userRequest.phone(), userRequest.email(), userRequest.password(), userRequest.cpf(), LocalDate.parse(userRequest.bornDate()), userRequest.imagePath());
        if (!user.passwordIsValid()) {
            return userPresenter.prepareFailView("User password must have more than 8 characters.");
        }
        OffsetDateTime now = OffsetDateTime.now();
        UserDtoRequestModel userDsModel = new UserDtoRequestModel(
                null, user.getName(), user.getPhone(), user.getEmail(), user.getPassword(), user.getCpf(), user.getBornDate().toString(), now.toString(), user.getImagePath(), Status.ACTIVE.getValue()
        );

        userDsGateway.save(userDsModel);

        UserLoginDtoResponseModel accountResponseModel = new UserLoginDtoResponseModel(user.getUsername(), now.toString(), "User created successfully!");
        return userPresenter.prepareSuccessView(accountResponseModel);
    }

    public Optional<UserDtoRequestModel> getById(int id) {
        return userDsGateway.findById(id);
    }

    public Iterable<UserDtoRequestModel> getAll() {
        Iterable<UserDtoRequestModel> users = userDsGateway.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserDtoRequestModel userDTO) {
        UserDtoRequestModel existingUser = userDsGateway.findById(userDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserDtoRequestModel updatedUser = new UserDtoRequestModel(
                userDTO.id(),
                userDTO.name() != null ? userDTO.name() : existingUser.name(),
                userDTO.phone() != null ? userDTO.phone() : existingUser.phone(),
                userDTO.email() != null ? userDTO.email() : existingUser.email(),
                userDTO.password() != null ? userDTO.password() : existingUser.password(),
                userDTO.cpf() != null ? userDTO.cpf() : existingUser.cpf(),
                userDTO.bornDate() != null ? userDTO.bornDate() : existingUser.bornDate(),
                existingUser.registerOn(),
                userDTO.imagePath() != null ? userDTO.imagePath() : existingUser.imagePath(),
                userDTO.status() != null ? userDTO.status() : existingUser.status()
        );

        userDsGateway.save(updatedUser);
    }

    public void delete(int id) {
        if (!userDsGateway.existsById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userDsGateway.deleteById(id);
    }

    public Optional<UserDtoRequestModel> findByEmail(String email) {
        return userDsGateway.findByEmail(email);
    }

    public Optional<UserDtoRequestModel> findByUsername(String username) {
        return userDsGateway.findByUsername(username);
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.existsByEmail(email) || userDsGateway.existsByUsername(username);
    }

    public Boolean existsById(int userId) {
        return userDsGateway.existsById(userId);
    }
}