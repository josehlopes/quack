package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.AddressEntity;

import java.util.Optional;

public interface IAddressRepository {
    AddressEntity save(AddressEntity address);

    Optional<AddressEntity> findById(int id);

    Iterable<AddressEntity> findAll();

    void deleteById(int id);
}