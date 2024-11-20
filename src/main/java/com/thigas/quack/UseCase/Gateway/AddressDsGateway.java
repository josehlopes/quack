package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.Address.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void save(AddressDsDtoRequestModel address);

    Optional<AddressInfoDtoResponseModel> getUserAddress(Integer userId, Integer addressId);

    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId);

    Optional<AddressInfoDtoResponseModel> getById(Integer id);

    Boolean existsById(Integer id);

    Boolean update(AddressDsDtoRequestModel address);

    Boolean deleteById(Integer id);
}