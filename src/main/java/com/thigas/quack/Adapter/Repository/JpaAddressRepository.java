package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAddressRepository extends JpaRepository<AddressDataMapper, Integer> {

}