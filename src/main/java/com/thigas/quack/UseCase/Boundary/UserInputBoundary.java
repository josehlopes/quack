package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    ResponseWrapper<GenericResponseModel> createUser(UserRegisterRequestModel request);

    ResponseWrapper<GenericResponseModel> updateUser(UserRequestModel request);

    ResponseWrapper<GenericResponseModel> deleteUser(Integer id);

    ResponseWrapper<GenericResponseModel> login(UserLoginRequestModel request);

}
