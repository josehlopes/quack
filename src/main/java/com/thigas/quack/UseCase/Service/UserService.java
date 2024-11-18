package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
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
    private final EncoderInputBoundary encoderInputBoundary;
    private final EncoderGateway encoderGateway;

    //TODO: ALTERAR NOME DOS MÉTODOS SE NECESSÁRIO
    public UserRegisterDtoResponseModel register(UserRegisterDtoRequestModel userRequest) {
        if (userDsGateway.findByEmail(userRequest.email())) {
            return userPresenter.prepareRegisterFailView(
                    new ErrorDtoResponseModel("This email is already in use", HttpStatus.CONFLICT.value())
            );
        }

        String encodedPassword = encoderInputBoundary.encode(userRequest.password());
        String encodedCpf = encoderInputBoundary.encode(userRequest.cpf());

        User user = userFactory.create(
                userRequest.name(), userRequest.surname(),userRequest.phone(), userRequest.email(), encodedPassword,
                encodedCpf, LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
        );

        if (!user.passwordIsValid()) {
            return userPresenter.prepareRegisterFailView(
                    new ErrorDtoResponseModel("User password must have at least 8 characters, one uppercase letter, and one special character.", HttpStatus.BAD_REQUEST.value())
            );
        }

        UserDtoRequestModel userDsModel = new UserDtoRequestModel(
                null, user.getName(), user.getSurname(), user.getFullName(), user.getUsername(),user.getPhone(), user.getEmail(), user.getPassword(),
                user.getCpf(), user.getBornDate().toString(), OffsetDateTime.now().toString(), user.getImagePath(), user.getIsActive()
        );

        userDsGateway.save(userDsModel);
        String token = tokenGateway.generateToken(user.getEmail());
        return userPresenter.prepareRegisterSuccessView(
                new UserRegisterDtoResponseModel(user.getEmail(), user.getPassword(), token)
        );
    }

    @Override
    public UserLoginDtoResponseModel login(UserLoginDtoRequestModel userRequest) {
        Optional<UserDtoRequestModel> user = userDsGateway.getByEmail(userRequest.email());
        if (user.isEmpty()) {
            return userPresenter.prepareLoginFailView(
                    new ErrorDtoResponseModel("User not found", HttpStatus.NOT_FOUND.value())
            );
        }
        if (!encoderGateway.match(userRequest.password(), user.get().password())) {
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
    }

    public void delete(Integer id) {
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

    public Boolean existsById(Integer userId) {
        return userDsGateway.findById(userId);
    }
}