package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void save(AddressRequestModel dataSourceModel);

    Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId);

    Optional<AddressInfoResponseModel> getById(Integer id);

    Boolean findById(Integer id);

    Boolean update(AddressRequestModel dataSourceModel);

    Boolean deleteById(Integer id);
}