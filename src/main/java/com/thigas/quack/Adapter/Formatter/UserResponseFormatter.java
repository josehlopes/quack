package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.UserPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class UserResponseFormatter implements UserPresenter {

    @Override
    public UserLoginDtoResponseModel prepareLoginSuccessView(UserLoginDtoResponseModel response) {
        return new UserLoginDtoResponseModel(response.id(), response.token());
    }

    @Override
    public UserLoginDtoResponseModel prepareLoginFailView(ErrorDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.valueOf(error.errorCode()), error.errorMessage());
    }

    @Override
    public UserRegisterDtoResponseModel prepareRegisterSuccessView(UserRegisterDtoResponseModel response) {
        return new UserRegisterDtoResponseModel(response.email(), response.password(), response.token());
    }

    @Override
    public UserRegisterDtoResponseModel prepareRegisterFailView(ErrorDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.valueOf(error.errorCode()), error.errorMessage());
    }
}