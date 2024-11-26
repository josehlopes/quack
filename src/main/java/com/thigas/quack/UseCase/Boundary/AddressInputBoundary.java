package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDsRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

import java.util.Optional;

public interface AddressInputBoundary {
    ResponseWrapper<GenericResponseModel> create(AddressCreateRequestModel address);

    Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId);

    ResponseWrapper<GenericResponseModel> update(AddressDsRequestModel addressDsRequestModel);

    ResponseWrapper<GenericResponseModel> delete(Integer id);
}
