package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;

import java.util.Optional;


public interface UserInputBoundary {
    UserLoginDtoResponseModel create(UserRegisterDtoRequestModel requestModel);
    Optional<UserDtoRequestModel> getById(int id);
    void update(UserDtoRequestModel userDto);
    void deleteById(int id);
    Iterable<UserDtoRequestModel> getAll();
}
