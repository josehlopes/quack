package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDsRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;

import java.util.Optional;

public interface AddressInputBoundary {
    Boolean create(AddressCreateRequestModel address);

    Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId);

    Boolean update(AddressDsRequestModel addressDsRequestModel);

    Boolean delete(Integer id);
}
