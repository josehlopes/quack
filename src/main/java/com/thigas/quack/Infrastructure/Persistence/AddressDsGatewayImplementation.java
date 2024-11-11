package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.AddressDataMapper;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaAddressRepository;
import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AddressDsGatewayImplementation implements AddressDsGateway {

    private final JpaAddressRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(AddressDtoRequestModel addressDtoRequest) {
        AddressDataMapper toSaveAddress = mapper.mapAddressDtoRequestToDataMapper(addressDtoRequest);
        repository.save(toSaveAddress);
    }

    @Override
    public Optional<AddressDtoRequestModel> findById(int id) {
        Optional<AddressDataMapper> address = repository.findById(id);
        return address.map(mapper::mapAddressDataMapperToDtoRequest);
    }

    @Override
    public List<AddressDtoRequestModel> findAll() {
        List<AddressDataMapper> addresses = repository.findAll();
        return addresses.stream()
                .map(mapper::mapAddressDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return repository.existsById(id);
    }
}