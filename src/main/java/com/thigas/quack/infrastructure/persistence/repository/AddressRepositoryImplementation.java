package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;

@Repository
public class AddressRepositoryImplementation implements IAddressRepository {

    @Autowired
    private IAddressModelRepository addressModelRepository;

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Override
    public AddressEntity save(AddressEntity address) {
        AddressModel addressModel = addressMapper.toAddressModel(address);
        AddressModel savedAddressModel = addressModelRepository.save(addressModel);
        return addressMapper.toAddress(savedAddressModel);
    }

    @Override
    public Optional<AddressEntity> findById(Long id) {
        return addressModelRepository.findById(id).map(addressMapper::toAddress);
    }

    @Override
    public Iterable<AddressEntity> findAll() {
        return addressModelRepository.findAll().stream()
                .map(addressMapper::toAddress)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        addressModelRepository.deleteById(id);
    }
}
