package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;

public interface UserPresenter {
    UserLoginDtoResponseModel prepareLoginSuccessView(UserLoginDtoResponseModel user);
    UserLoginDtoResponseModel prepareLoginFailView(ErrorDtoResponseModel error);
    UserRegisterDtoResponseModel prepareRegisterSuccessView(UserRegisterDtoResponseModel user);
    UserRegisterDtoResponseModel prepareRegisterFailView(ErrorDtoResponseModel error);
}
