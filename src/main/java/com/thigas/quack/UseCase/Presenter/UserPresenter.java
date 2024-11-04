package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.UserResponseModel;

public interface UserPresenter {
    UserResponseModel prepareSuccessView(UserResponseModel user);
    UserResponseModel prepareFailView(String error);
}
