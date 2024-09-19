package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    // Instância do mapper
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    @Autowired
    private IAddressRepository addressRepository;

    public AddressDTO create(AddressDTO addressDTO) {
        AddressEntity address = addressMapper.dtoToEntity(addressDTO);
        AddressEntity toSaveAddress = addressRepository.save(address);
        return addressMapper.entityToDto(toSaveAddress);
    }

    public Optional<AddressDTO> getById(int id) {
        Optional<AddressEntity> address = addressRepository.findById(id);
        return address.map(addressMapper::entityToDto);
    }

    public Iterable<AddressDTO> getAll() {
        Iterable<AddressEntity> addresses = addressRepository.findAll();
        return StreamSupport.stream(addresses.spliterator(), false).map(addressMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        AddressEntity address = addressMapper.dtoToEntity(addressDTO);
        addressRepository.save(address);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
