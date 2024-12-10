package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void saveAddress(AddressRequestModel request);

    Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId);

    Optional<AddressInfoResponseModel> getById(Integer id);

    Boolean existsById(Integer id);

    Boolean updateAddress(AddressRequestModel request);

    Boolean deleteById(Integer id);

    Boolean updateAddressIsActive(Integer id, boolean isActive);
}