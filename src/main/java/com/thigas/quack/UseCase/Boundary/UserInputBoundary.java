package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;

import java.util.Optional;


public interface UserInputBoundary {
    UserRegisterDtoResponseModel create(UserRegisterDtoRequestModel requestModel);
    UserLoginDtoResponseModel login(UserLoginDtoRequestModel requestModel);
    void update(UserDtoRequestModel userDto);
    void delete(int id);
}
