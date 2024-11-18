package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;

import java.util.Optional;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    UserRegisterDtoResponseModel register(UserRegisterDtoRequestModel requestModel);
    UserLoginDtoResponseModel login(UserLoginDtoRequestModel requestModel);
    void update(UserDtoRequestModel userDto);
    void delete(Integer id);

}
