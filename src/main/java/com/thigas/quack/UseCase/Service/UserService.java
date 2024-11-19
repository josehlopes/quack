package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.UserFactory;
import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Boundary.EncoderInputBoundary;
import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Gateway.EncoderGateway;
import com.thigas.quack.UseCase.Gateway.TokenGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.UserMapper;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserInfoDtoResponseModel;
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
    private final UserMapper userMapper;
    private final ResponseService responseService;

    public ResultDtoResponseModel register(UserRegisterDtoRequestModel userRequest) {
        if (userDsGateway.findByEmail(userRequest.email())) {
            return userPresenter.prepareRegisterFailView(
                    responseService.createErrorResponse("This email is already in use", HttpStatus.CONFLICT)
            );
        }

        String encodedPassword = encoderInputBoundary.encode(userRequest.password());
        String encodedCpf = encoderInputBoundary.encode(userRequest.cpf());

        User user = userFactory.create(
                userRequest.name(), userRequest.surname(), userRequest.phone(), userRequest.email(), encodedPassword,
                encodedCpf, LocalDate.parse(userRequest.bornDate()), userRequest.imagePath()
        );

        UserDsDtoRequestModel userDsModel = userMapper.toDsModel(user);

        userDsGateway.save(userDsModel);
        String token = tokenGateway.generateToken(user.getEmail());
        return userPresenter.prepareRegisterSuccessView(responseService.createSuccessResponse(
                String.format("User registered successfully: %s, %s, %s", user.getEmail(), token), HttpStatus.CREATED)
        );
    }

    @Override
    public ResultDtoResponseModel login(UserLoginDtoRequestModel userRequest) {
        Optional<UserDsDtoRequestModel> user = userDsGateway.getByEmail(userRequest.email());
        if (user.isEmpty()) {
            return userPresenter.prepareLoginFailView(
                    new ResultDtoResponseModel("User not found", HttpStatus.NOT_FOUND.value(), ResponseType.ERROR)
            );
        }
        if (!encoderGateway.match(userRequest.password(), user.get().password())) {
            return userPresenter.prepareLoginFailView(
                    new ResultDtoResponseModel("Invalid password", HttpStatus.UNAUTHORIZED.value(), ResponseType.ERROR)
            );
        }
        String token = tokenGateway.generateToken(user.get().email());
        return userPresenter.prepareLoginSuccessView(responseService.createSuccessResponse(
                String.format("User logged in successfully: %s, %s", user.get().email(), token), HttpStatus.OK)
        );
    }

    public Optional<UserDsDtoRequestModel>getById(int id) {
        return userDsGateway.getById(id);
    }

    public Iterable<UserDsDtoRequestModel> getAll() {
        Iterable<UserDsDtoRequestModel> users = userDsGateway.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserDsDtoRequestModel userDTO) {
        UserDsDtoRequestModel existingUser = userDsGateway.getById(userDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        UserDsDtoRequestModel updatedUser = new UserDsDtoRequestModel(
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

    public void delete(int id) {
        if (!userDsGateway.findById(id)) {
            throw new EntityNotFoundException("User not found");
        }
        userDsGateway.deleteById(id);
    }

    public Optional<UserDsDtoRequestModel> findByEmail(String email) {
        return userDsGateway.getByEmail(email);
    }

    public Optional<UserDsDtoRequestModel> findByUsername(String username) {
        return userDsGateway.getByUsername(username);
    }

    public boolean existsByEmailOrUsername(String email, String username) {
        return userDsGateway.findByEmail(email) || userDsGateway.findByUsername(username);
    }

    public Boolean existsById(int userId) {
        return userDsGateway.findById(userId);
    }
}