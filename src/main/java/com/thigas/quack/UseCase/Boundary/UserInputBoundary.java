package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.Adapter.Dto.UserRegisterDTO;
import com.thigas.quack.UseCase.Model.Response.UserResponseModel;

public interface UserInputBoundary {
    UserResponseModel create(UserRegisterDTO requestModel);
}
