package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.Address;

public interface IAddressRepository {
    Address save(Address address);

    Optional<Address> findById(Long id);

    Iterable<Address> findAll();

    void deleteById(Long id);
}