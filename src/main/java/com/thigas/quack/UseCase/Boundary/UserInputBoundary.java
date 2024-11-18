package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserRegisterDtoResponseModel;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    UserRegisterDtoResponseModel register(UserRegisterDtoRequestModel requestModel);

    UserLoginDtoResponseModel login(UserLoginDtoRequestModel requestModel);

    void update(UserDsDtoRequestModel userDto);

    void delete(int id);

}
