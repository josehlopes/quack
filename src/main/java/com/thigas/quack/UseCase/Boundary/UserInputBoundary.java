package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.User.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.User.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.User.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.User.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.User.UserRegisterDtoResponseModel;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    UserRegisterDtoResponseModel register(UserRegisterDtoRequestModel requestModel);

    UserLoginDtoResponseModel login(UserLoginDtoRequestModel requestModel);

    Boolean update(UserDsDtoRequestModel userDto);

    Boolean delete(Integer id);

}
