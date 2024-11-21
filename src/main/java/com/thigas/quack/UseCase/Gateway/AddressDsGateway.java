package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressDsRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void save(AddressDsRequestModel address);

    Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId);

    Optional<AddressInfoResponseModel> getById(Integer id);

    Boolean existsById(Integer id);

    Boolean update(AddressDsRequestModel address);

    Boolean deleteById(Integer id);
}