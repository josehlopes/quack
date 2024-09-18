package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressModelRepository extends JpaRepository<AddressModel, Integer> {

}