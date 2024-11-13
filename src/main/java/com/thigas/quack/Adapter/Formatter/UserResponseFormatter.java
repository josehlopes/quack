package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserResponseFormatter implements UserPresenter {

    @Override
    public UserLoginDtoResponseModel prepareSuccessView(UserLoginDtoResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.creationTime());
        String formattedTime = responseTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return new UserLoginDtoResponseModel(response.login(), formattedTime, "Sucesso!" );
    }

    @Override
    public UserLoginDtoResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}