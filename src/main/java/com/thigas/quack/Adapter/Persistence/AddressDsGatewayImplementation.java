package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.UseCase.Mapper.AddressMapper;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Adapter.Repository.AddressRepository;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AddressDsGatewayImplementation implements AddressDsGateway {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public void save(AddressDsDtoRequestModel addressDtoRequest) {
        AddressDataMapper toSaveAddress = mapper.toDataMapper(addressDtoRequest);
        repository.save(toSaveAddress);
    }

    @Override
    public Optional<AddressInfoDtoResponseModel> getById(int id) {
        Optional<AddressDataMapper> address = repository.getById(id);
        return address.map(mapper::toInfoDto);
    }

    @Override
    public Optional<AddressInfoDtoResponseModel> getByUserId(int userId) {
        Optional<AddressDataMapper> address = repository.getByUserId(userId);
        return address.map(mapper::toInfoDto);
    }

    @Override
    public Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(int userId) {
        Iterable<AddressDataMapper> addresses = repository.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(mapper::toInfoDto)
                .collect(Collectors.toList());    }

    @Override
    public Boolean update(AddressDsDtoRequestModel addressDtoRequest) {
        AddressDataMapper toUpdateAddress = mapper.toDataMapper(addressDtoRequest);
        repository.update(toUpdateAddress);
        return true;
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