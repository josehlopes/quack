package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IAddressModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class AddressRepositoryImplementation implements IAddressRepository {


    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private IAddressModelRepository addressModelRepository;

    @Override
    @Transactional
    public AddressEntity save(AddressEntity addressEntity) {
        AddressModel addressModel = addressMapper.entityToModel(addressEntity);
        AddressModel savedAddressModel = addressModelRepository.save(addressModel);
        return addressMapper.modelToEntity(savedAddressModel);
    }

    @Override
    @Transactional
    public Optional<AddressEntity> findById(int id) {
        return addressModelRepository.findById(id).map(addressMapper::modelToEntity);
    }

    @Override
    @Transactional
    public Iterable<AddressEntity> findAll() {
        return addressModelRepository.findAll().stream().map(addressMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        addressModelRepository.deleteById(id);
    }
}
