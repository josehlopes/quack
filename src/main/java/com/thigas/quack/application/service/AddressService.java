package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
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

    @Autowired
    private CycleAvoidingMappingContext context;

    public AddressDTO create(AddressDTO addressDTO) {
        AddressModel addressModel = addressMapper.dtoToModel(addressDTO, new CycleAvoidingMappingContext());
        AddressModel savedAddress = addressRepository.save(addressModel);
        return addressMapper.modelToDto(savedAddress, context);
    }

    public Optional<AddressDTO> getById(int id) {
        Optional<AddressModel> addressOptional = addressRepository.findById(id);
        return addressOptional.map(address -> addressMapper.modelToDto(address, new CycleAvoidingMappingContext()));
    }

    public Iterable<AddressDTO> getAll() {
        Iterable<AddressModel> addresses = addressRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(address -> addressMapper.modelToDto(address, context))
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
