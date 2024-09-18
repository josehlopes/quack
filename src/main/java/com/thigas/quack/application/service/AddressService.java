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
        // Converter DTO para entidade
        AddressEntity address = addressMapper.DtoToEntity(addressDTO);
        // Salvar a entidade
        AddressEntity toSaveAddress = addressRepository.save(address);
        // Converter entidade de volta para DTO
        return addressMapper.EntityToDto(toSaveAddress);
    }

    public Optional<AddressDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<AddressEntity> address = addressRepository.findById(id);
        // Converter a entidade para DTO
        return address.map(addressMapper::EntityToDto);
    }

    public Iterable<AddressDTO> getAll() {
        // Buscar todas as entidades
        Iterable<AddressEntity> addresses = addressRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(addressMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(AddressDTO addressDTO) {
        // Converter DTO para entidade
        AddressEntity address = addressMapper.DtoToEntity(addressDTO);
        // Atualizar a entidade
        addressRepository.save(address);
    }

    public void delete(int id) {
        addressRepository.deleteById(id);
    }
}
