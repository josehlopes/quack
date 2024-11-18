package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.Domain.Factory.AddressFactory;
import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserInfoDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AddressService implements AddressInputBoundary {

    private final AddressDsGateway addressDsGateway;
    private final AddressPresenter addressPresenter;
    private final AddressFactory addressFactory;
    private final UserDsGateway userDsGateway;

    public ResultDtoResponseModel create(AddressCreateDtoRequestModel addressCreateDtoRequestModel) {
        UserDsDtoRequestModel userDto = userDsGateway.getById(addressCreateDtoRequestModel.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Address address = addressFactory.create(
                addressCreateDtoRequestModel.street(),
                addressCreateDtoRequestModel.city(),
                addressCreateDtoRequestModel.state(),
                addressCreateDtoRequestModel.country(),
                addressCreateDtoRequestModel.zipCode(),
                addressCreateDtoRequestModel.number()
        );

        AddressDsDtoRequestModel addressDsDtoRequestModel = new AddressDsDtoRequestModel(
                null,
                addressCreateDtoRequestModel.userId(),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getZipCode(),
                address.getNumber(),
                address.getIsActive()
        );

        addressDsGateway.update(addressDsDtoRequestModel);
        return new ResultDtoResponseModel("Address created successfully", HttpStatus.CREATED.value(), ResponseType.SUCCESS);
    }

    public Optional<AddressInfoDtoResponseModel> getByUserId(int userId) {
        Optional<AddressInfoDtoResponseModel> address = addressDsGateway.getByUserId(userId);
        return address.map(addressDtoRequestModel -> addressPresenter.prepareGetAddressSuccessView(
                new AddressInfoDtoResponseModel(addressDtoRequestModel.id(),
                        addressDtoRequestModel.street(),
                        addressDtoRequestModel.city(), addressDtoRequestModel.state(), addressDtoRequestModel.country(), addressDtoRequestModel.zipCode(),
                        addressDtoRequestModel.number())
        )).or(() -> Optional.of(addressPresenter.prepareGetAddressFailView(
                new ResultDtoResponseModel("Address not found", HttpStatus.NOT_FOUND.value(), ResponseType.ERROR)
        )));
    }

    public Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(int userId) {
        Iterable<AddressInfoDtoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(address -> new AddressInfoDtoResponseModel(address.id(),address.street(),
                        address.city(), address.state(), address.country(), address.zipCode(), address.number()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(AddressDsDtoRequestModel addressDtoRequest) {
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
                addressDtoRequest.isActive()
        );

        addressDsGateway.save(updatedAddress);
    }

    @Override
    public void delete(int id) {
        if (!addressDsGateway.existsById(id)) {
            throw new EntityNotFoundException("Address not found");
        }
        addressDsGateway.deleteById(id);
    }
}