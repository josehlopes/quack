package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IAddressModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AddressRepositoryImplementation implements IAddressRepository {

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    @Autowired
    private IAddressModelRepository addressModelRepository;

    @Override
    public AddressEntity save(AddressEntity address) {
        AddressModel addressModel = addressMapper.EntityToModel(address);
        AddressModel savedAddressModel = addressModelRepository.save(addressModel);
        return addressMapper.ModelToEntity(savedAddressModel);
    }

    @Override
    public Optional<AddressEntity> findById(int id) {
        return addressModelRepository.findById(id).map(addressMapper::ModelToEntity);
    }

    @Override
    public Iterable<AddressEntity> findAll() {
        return addressModelRepository.findAll().stream()
                .map(addressMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        addressModelRepository.deleteById(id);
    }
}
