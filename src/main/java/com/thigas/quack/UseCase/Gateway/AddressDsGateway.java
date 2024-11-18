package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void save(AddressDtoRequestModel address);
    Optional<AddressInfoDtoResponseModel> getByUserId(Integer userId);
    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId);
    Optional<AddressInfoDtoResponseModel> getById(Integer id);
    Boolean update(AddressDtoRequestModel address);
    void deleteById(Integer id);
    Boolean existsById(Integer id);
}