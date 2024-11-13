package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;

import java.util.Optional;

public interface AddressDsGateway {

    void save(AddressDtoRequestModel address);

    Optional<AddressDtoRequestModel> findById(int id);

    Iterable<AddressDtoRequestModel> findAll();

    void deleteById(int id);

    Boolean existsById(int id);
}