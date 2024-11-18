package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;

import java.util.Optional;

public interface AddressDsGateway {
    void save(AddressDsDtoRequestModel address);
    Optional<AddressInfoDtoResponseModel> getByUserId(int userId);
    Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(int userId);
    Optional<AddressInfoDtoResponseModel> getById(int id);
    Boolean existsById(int id);

    ResultDtoResponseModel update(AddressDsDtoRequestModel address);

    void deleteById(int id);
}