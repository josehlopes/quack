package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.adapter.mapper.AddressMapper;
import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.domain.repository.IAddressRepository;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    // Instância do mapper
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    public AddressDTO create(AddressDTO addressDTO) {
        // Converter DTO para entidade
        Address address = addressMapper.toAddress(addressDTO);
        // Salvar a entidade
        Address toSaveAddress = addressRepository.save(address);
        // Converter entidade de volta para DTO
        return addressMapper.toAddressDTO(toSaveAddress);
    }

    public Optional<AddressDTO> getById(Long id) {
        // Buscar a entidade do repositório
        Optional<Address> address = addressRepository.findById(id);
        // Converter a entidade para DTO
        return address.map(addressMapper::toAddressDTO);
    }

    public Iterable<AddressDTO> getAll() {
        // Buscar todas as entidades
        Iterable<Address> addresses = addressRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(addressMapper::toAddressDTO)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        // Converter DTO para entidade
        Address address = addressMapper.toAddress(addressDTO);
        // Atualizar a entidade
        addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
