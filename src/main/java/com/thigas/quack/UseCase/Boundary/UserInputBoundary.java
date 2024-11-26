package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    ResponseWrapper<GenericResponseModel> register(UserRegisterRequestModel request);

    ResponseWrapper<GenericResponseModel> login(UserLoginRequestModel request);

    ResponseWrapper<GenericResponseModel> update(UserDsRequestModel request);

    ResponseWrapper<GenericResponseModel> delete(Integer id);

}
