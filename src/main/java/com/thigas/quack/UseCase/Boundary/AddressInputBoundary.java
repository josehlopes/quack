package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;

import java.util.Optional;

public interface AddressInputBoundary {
    ResultDtoResponseModel create(AddressCreateDtoRequestModel address);

    Optional<AddressInfoDtoResponseModel> getByUserId(int userId);
    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(int userId);

    void update(AddressDsDtoRequestModel userDto);

    void delete(int id);
}
