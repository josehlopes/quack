package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Adapter.Repository.AddressRepository;
import com.thigas.quack.Adapter.Repository.JpaAddressRepository;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AddressDsGatewayImplementation implements AddressDsGateway {

    private final AddressRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(AddressDtoRequestModel addressDtoRequest) {
        AddressDataMapper toSaveAddress = mapper.mapAddressDtoRequestToDataMapper(addressDtoRequest);
        repository.save(toSaveAddress);
    }

    @Override
    public Optional<AddressInfoDtoResponseModel> getById(Integer id) {
        Optional<AddressDataMapper> address = repository.getById(id);
        return address.map(mapper::mapAddressDataMapperToInfoDtoResponse);
    }

    @Override
    public Optional<AddressInfoDtoResponseModel> getByUserId(Integer userId) {
        Optional<AddressDataMapper> address = repository.getByUserId(userId);
        return address.map(mapper::mapAddressDataMapperToInfoDtoResponse);
    }

    @Override
    public Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId) {
        Iterable<AddressDataMapper> addresses = repository.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(mapper::mapAddressDataMapperToInfoDtoResponse)
                .collect(Collectors.toList());    }

    @Override
    public Boolean update(AddressDtoRequestModel addressDtoRequest) {
        AddressDataMapper toUpdateAddress = mapper.mapAddressDtoRequestToDataMapper(addressDtoRequest);
        repository.update(toUpdateAddress);
        return true;
    }
    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}