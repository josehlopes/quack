package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

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
    private final TokenGateway tokenGateway;

    //TODO: ALTERAR NOME DOS MÉTODOS SE NECESSÁRIO
    public UserRegisterDtoResponseModel create(UserRegisterDtoRequestModel userRequest) {
        if (userDsGateway.findByEmail(userRequest.email())) {
            return userPresenter.prepareRegisterFailView(
                    new ErrorDtoResponseModel("User already exists", HttpStatus.CONFLICT.value())
            );
        }
        User user = userFactory.create(
                userRequest.name(), userRequest.phone(), userRequest.email(), userRequest.password(),
                userRequest.cpf(), LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
        );
        if (!user.passwordIsValid()) {
            return userPresenter.prepareRegisterFailView(
                    new ErrorDtoResponseModel("User password must have more than 8 characters.", HttpStatus.BAD_REQUEST.value())
            );
        }
        OffsetDateTime now = OffsetDateTime.now();
        UserDtoRequestModel userDsModel = new UserDtoRequestModel(
                null, user.getName(), user.getPhone(), user.getEmail(), user.getPassword(),
                user.getCpf(), user.getBornDate().toString(), now.toString(), user.getImagePath(), Status.ACTIVE.getValue()
        );
        userDsGateway.save(userDsModel);
        String token = tokenGateway.generateToken(user.getEmail());
        UserRegisterDtoResponseModel accountResponseModel = new UserRegisterDtoResponseModel(user.getEmail(), user.getPassword(), token);
        return userPresenter.prepareRegisterSuccessView(accountResponseModel);
    }

    @Override
    public UserLoginDtoResponseModel login(UserLoginDtoRequestModel userRequest) {
        Optional<UserDtoRequestModel> user = userDsGateway.getByEmail(userRequest.email());
        if (user.isEmpty()) {
            return userPresenter.prepareLoginFailView(
                    new ErrorDtoResponseModel("User not found", HttpStatus.NOT_FOUND.value())
            );
        }
        if (!user.get().password().equals(userRequest.password())) {
            return userPresenter.prepareLoginFailView(
                    new ErrorDtoResponseModel("Invalid password", HttpStatus.UNAUTHORIZED.value())
            );
        }
        String token = tokenGateway.generateToken(user.get().email());
        return userPresenter.prepareLoginSuccessView(new UserLoginDtoResponseModel(user.get().id(), token));
    }

    public Optional<UserDtoRequestModel>getById(int id) {
        return userDsGateway.getById(id);
    }

    public Iterable<UserDtoRequestModel> getAll() {
        Iterable<UserDtoRequestModel> users = userDsGateway.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserDtoRequestModel userDTO) {
        UserDtoRequestModel existingUser = userDsGateway.getById(userDTO.id())
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
        if (!userDsGateway.findById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userDsGateway.deleteById(id);
    }

    public Optional<UserDtoRequestModel> findByEmail(String email) {
        return userDsGateway.getByEmail(email);
    }

    public Optional<UserDtoRequestModel> findByUsername(String username) {
        return userDsGateway.getByUsername(username);
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.findByEmail(email) || userDsGateway.findByUsername(username);
    }

    public Boolean existsById(int userId) {
        return userDsGateway.findById(userId);
    }
}