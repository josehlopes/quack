package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IAddressModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AddressRepositoryImplementation implements IAddressRepository {


    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IAddressModelRepository addressModelRepository;

    @Autowired
    private CycleAvoidingMappingContext context;

    @Override
    @Transactional
    public AddressModel save(AddressModel addressModel) {
        return addressModelRepository.save(addressModel);
    }

    @Override
    @Transactional
    public Optional<AddressModel> findById(int id) {
        return addressModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<AddressModel> findAll() {
        return addressModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        addressModelRepository.deleteById(id);
    }
}
