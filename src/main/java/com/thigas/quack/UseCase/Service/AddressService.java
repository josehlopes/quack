package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.Domain.Factory.AddressFactory;
import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.AddressMapper;
import com.thigas.quack.UseCase.Model.Request.Address.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.Address.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.User.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AddressService implements AddressInputBoundary {

    private final AddressDsGateway addressDsGateway;
    private final AddressPresenter addressPresenter;
    private final AddressFactory addressFactory;
    private final AddressMapper addressMapper;
    private final UserDsGateway userDsGateway;
    private final ResponseService responseService;

    public Boolean create(AddressCreateDtoRequestModel addressCreateDtoRequestModel) {
        UserDsDtoRequestModel userDto = userDsGateway.getById(addressCreateDtoRequestModel.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Address address = addressFactory.create(
                userDto.id(),
                addressCreateDtoRequestModel.street(),
                addressCreateDtoRequestModel.city(),
                addressCreateDtoRequestModel.state(),
                addressCreateDtoRequestModel.country(),
                addressCreateDtoRequestModel.zipCode(),
                addressCreateDtoRequestModel.number()
        );

        Boolean isValid = address.isValid();
        Boolean isCepValid = address.isCepValid();

        if (!isValid || !isCepValid) {
            return false;
        }

        AddressDsDtoRequestModel addressDsDtoRequestModel = addressMapper.toDsModel(address);

        addressDsGateway.save(addressDsDtoRequestModel);
        return true;
    }

    public Optional<AddressInfoDtoResponseModel> getUserAddress(Integer userId, Integer addressId) {
        return addressDsGateway.getUserAddress(userId, addressId);
    }

    public Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId) {
        Iterable<AddressInfoDtoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean update(AddressDsDtoRequestModel addressDtoRequest) {
        AddressInfoDtoResponseModel existingAddress = addressDsGateway.getById(addressDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));

        AddressDsDtoRequestModel updatedAddress = new AddressDsDtoRequestModel(
                addressDtoRequest.id(),
                addressDtoRequest.userId(),
                addressDtoRequest.street() != null ? addressDtoRequest.street() : existingAddress.street(),
                addressDtoRequest.city() != null ? addressDtoRequest.city() : existingAddress.city(),
                addressDtoRequest.state() != null ? addressDtoRequest.state() : existingAddress.state(),
                addressDtoRequest.country() != null ? addressDtoRequest.country() : existingAddress.country(),
                addressDtoRequest.zipCode() != null ? addressDtoRequest.zipCode() : existingAddress.zipCode(),
                addressDtoRequest.number() != null ? addressDtoRequest.number() : existingAddress.number(),
                true
        );

        addressDsGateway.update(updatedAddress);
        return true;
    }

    @Override
    public Boolean delete(Integer id) {
        if (!addressDsGateway.existsById(id)) {
            throw new NoSuchElementException("Address not found");
        }
        addressDsGateway.deleteById(id);
        return true;
    }
}