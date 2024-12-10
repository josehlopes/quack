package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Adapter.Repository.AddressRepository;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Mapper.AddressMapper;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AddressDsGatewayImplementation implements AddressDsGateway {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public void saveAddress(AddressRequestModel addressDtoRequest) {
        AddressDataMapper toSaveAddress = mapper.toDataMapper(addressDtoRequest);
        repository.save(toSaveAddress);
    }

    @Override
    public Optional<AddressInfoResponseModel> getById(Integer id) {
        Optional<AddressDataMapper> address = repository.getById(id);
        return address.map(mapper::toInfoDto);
    }

    @Override
    public Optional<AddressInfoResponseModel> getUserAddress(Integer userId, Integer addressId) {
        Optional<AddressDataMapper> address = repository.getUserAddress(userId, addressId);
        return address.map(mapper::toInfoDto);
    }

    @Override
    public Iterable<AddressInfoResponseModel> getAllUserAddresses(Integer userId) {
        Iterable<AddressDataMapper> addresses = repository.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(mapper::toInfoDto)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateAddress(AddressRequestModel addressDtoRequest) {
        AddressDataMapper toUpdateAddress = mapper.toDataMapper(addressDtoRequest);
        repository.update(toUpdateAddress);
        return true;
    }

    @Override
    public Boolean deleteById(Integer id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Boolean updateAddressIsActive(Integer id, boolean isActive) {
        int rowsUpdated = repository.updateAddressIsActive(id, isActive);
        return rowsUpdated > 0;
    }

}