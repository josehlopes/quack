package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.Address.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.Address.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;

import java.util.Optional;

public interface AddressInputBoundary {
    Boolean create(AddressCreateDtoRequestModel address);

    Optional<AddressInfoDtoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId);

    Boolean update(AddressDsDtoRequestModel addressDsDtoRequestModel);

    Boolean delete(Integer id);
}
