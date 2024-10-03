package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private AddressMapper addressMapper;

    public AddressDTO create(AddressDTO addressDTO) {
        AddressModel addressModel = addressMapper.dtoToModel(addressDTO);
        AddressModel savedAddress = addressRepository.save(addressModel);
        return addressMapper.modelToDto(savedAddress);
    }

    public Optional<AddressDTO> getById(int id) {
        Optional<AddressModel> address = addressRepository.findById(id);
        return address.map(addressMapper::modelToDto);
    }

    public Iterable<AddressDTO> getAll() {
        Iterable<AddressModel> addresss = addressRepository.findAll();
        return StreamSupport.stream(addresss.spliterator(), false).map(addressMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        AddressModel existingUser = addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        addressRepository.save(existingUser);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
