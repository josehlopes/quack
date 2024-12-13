package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.ProfileImageRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLoginRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

import java.io.IOException;


//TODO: DEIXAR APENAS MÉTODOS RELACIONADOS A ENTRADA DE DADOS
public interface UserInputBoundary {
    ResponseWrapper<GenericResponseModel> createUser(UserRegisterRequestModel request);

    ResponseWrapper<GenericResponseModel> updateUser(UserRequestModel request);
    
    ResponseWrapper<GenericResponseModel> login(UserLoginRequestModel request);

    ResponseWrapper<GenericResponseModel> deactivateUser(Integer id);
    
    ResponseWrapper<GenericResponseModel> saveProfileImage(Integer userId, ProfileImageRequestModel imageFile) throws IOException;
}
