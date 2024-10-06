package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.domain.repository.IAddressRepository;
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
    private ObjectMapperService objectMapperService;

    public AddressDTO create(AddressDTO addressDTO) {
        AddressModel addressModel = objectMapperService.toModel(addressDTO);
        AddressModel savedAddress = addressRepository.save(addressModel);
        return objectMapperService.toDto(savedAddress);
    }

    public Optional<AddressDTO> getById(int id) {
        Optional<AddressModel> address = addressRepository.findById(id);
        return address.map(objectMapperService::toDto);
    }

    public Iterable<AddressDTO> getAll() {
        Iterable<AddressModel> addresses = addressRepository.findAll();
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        AddressModel existingAddress = addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));
        AddressModel updatedAddress = objectMapperService.toModel(addressDTO);
        addressRepository.save(updatedAddress);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
