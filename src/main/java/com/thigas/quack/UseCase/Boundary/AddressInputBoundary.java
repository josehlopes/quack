package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.SuccessDtoResponseModel;

import java.util.Optional;

public interface AddressInputBoundary {
    SuccessDtoResponseModel create(AddressCreateDtoRequestModel address);
    Optional<AddressInfoDtoResponseModel> getByUserId(Integer userId);
    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId);
    void update(AddressDtoRequestModel userDto);
    void delete(Integer id);
}
