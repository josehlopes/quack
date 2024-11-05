package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Entity.AddressDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAddressRepository extends JpaRepository<AddressDataMapper, Integer> {

}