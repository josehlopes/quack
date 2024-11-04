package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.AddressDataMapper;

import java.util.Optional;

public interface AddressDsGateway {

    void save(AddressDataMapper address);
    Optional<AddressDataMapper> findById(int id);
    Iterable<AddressDataMapper> findAll();
    void deleteById(int id);
}