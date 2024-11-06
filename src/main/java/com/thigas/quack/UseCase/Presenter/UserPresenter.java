package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;

public interface UserPresenter {
    UserLoginDtoResponseModel prepareSuccessView(UserLoginDtoResponseModel user);
    UserLoginDtoResponseModel prepareFailView(String error);
}
