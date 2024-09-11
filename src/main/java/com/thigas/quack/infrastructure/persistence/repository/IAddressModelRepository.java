package com.thigas.quack.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thigas.quack.infrastructure.persistence.entity.AddressModel;

public interface IAddressModelRepository extends JpaRepository<AddressModel, Long> {

}