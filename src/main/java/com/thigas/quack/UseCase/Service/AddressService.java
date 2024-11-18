package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.Domain.Entity.CommonUser;
import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Factory.AddressFactory;
import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressCreateDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.SuccessDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AddressService implements AddressInputBoundary {

    private final AddressDsGateway addressDsGateway;
    private final AddressPresenter addressPresenter;
    private final AddressFactory addressFactory;
    private final UserDsGateway userDsGateway;

    public SuccessDtoResponseModel create(AddressCreateDtoRequestModel addressCreateDtoRequestModel) {
        UserDtoRequestModel userDto = userDsGateway.getById(addressCreateDtoRequestModel.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Address address = addressFactory.create(
                addressCreateDtoRequestModel.street(),
                addressCreateDtoRequestModel.city(),
                addressCreateDtoRequestModel.state(),
                addressCreateDtoRequestModel.country(),
                addressCreateDtoRequestModel.zipCode(),
                addressCreateDtoRequestModel.number()
        );

        AddressDtoRequestModel addressDtoRequestModel = new AddressDtoRequestModel(
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

        addressDsGateway.update(addressDtoRequestModel);
        return new SuccessDtoResponseModel("Address created successfully", HttpStatus.CREATED.value());
    }

    public Optional<AddressInfoDtoResponseModel> getByUserId(Integer userId) {
        Optional<AddressInfoDtoResponseModel> address = addressDsGateway.getByUserId(userId);
        return address.map(addressDtoRequestModel -> addressPresenter.prepareGetAddressSuccessView(
                new AddressInfoDtoResponseModel(addressDtoRequestModel.street(),
                        addressDtoRequestModel.city(), addressDtoRequestModel.state(), addressDtoRequestModel.country(), addressDtoRequestModel.zipCode(),
                        addressDtoRequestModel.number())
        )).or(() -> Optional.of(addressPresenter.prepareGetAddressFailView(
                new ErrorDtoResponseModel("Address not found", HttpStatus.NOT_FOUND.value())
        )));
    }

    public Iterable<AddressInfoDtoResponseModel> getAllUserAddresses(Integer userId) {
        Iterable<AddressInfoDtoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
        return StreamSupport.stream(addresses.spliterator(), false)
                .map(address -> new AddressInfoDtoResponseModel(address.street(),
                        address.city(), address.state(), address.country(), address.zipCode(), address.number()))
                .collect(Collectors.toList());
    }

    @Override
    public void update(AddressDtoRequestModel addressDtoRequest) {
        AddressInfoDtoResponseModel existingAddress = addressDsGateway.getById(addressDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));

        AddressDtoRequestModel updatedAddress = new AddressDtoRequestModel(
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
    public void delete(Integer id) {
        if (!addressDsGateway.existsById(id)) {
            throw new EntityNotFoundException("Address not found");
        }
        addressDsGateway.deleteById(id);
    }
}