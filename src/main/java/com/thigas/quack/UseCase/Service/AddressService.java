package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.AddressDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.Infrastructure.Entity.AddressDataMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AddressService {

    @Autowired
    private AddressDsGateway addressRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(AddressDTO addressDTO) {
        AddressDataMapper addressDataMapper = objectMapperService.toModel(addressDTO);
        addressRepository.save(addressDataMapper);
    }

    public Optional<AddressDTO> getById(int id) {
        Optional<AddressDataMapper> address = addressRepository.findById(id);
        return address.map(objectMapperService::toDto);
    }

    public Iterable<AddressDTO> getAll() {
        Iterable<AddressDataMapper> addresses = addressRepository.findAll();
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        AddressDataMapper existingAddress = addressRepository.findById(addressDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));
        AddressDataMapper updatedAddress = objectMapperService.toModel(addressDTO);
        addressRepository.save(updatedAddress);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
