package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.Adapter.Dto.UserRegisterDTO;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserResponseModel;

public interface UserInputBoundary {
    UserResponseModel create(UserDtoRequestModel requestModel);
}
