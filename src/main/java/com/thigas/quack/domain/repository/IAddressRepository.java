package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.AddressModel;

import java.util.Optional;

public interface IAddressRepository {

    AddressModel save(AddressModel address);

    Optional<AddressModel> findById(int id);

    Iterable<AddressModel> findAll();

    void deleteById(int id);

}