package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;


public interface UserInputBoundary {
    UserLoginDtoResponseModel create(UserRegisterDtoRequestModel requestModel);
}
