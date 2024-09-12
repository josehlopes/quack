package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.AddressEntity;

public interface IAddressRepository {
    AddressEntity save(AddressEntity address);

    Optional<AddressEntity> findById(Long id);

    Iterable<AddressEntity> findAll();

    void deleteById(Long id);
}