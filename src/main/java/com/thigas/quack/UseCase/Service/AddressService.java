package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.Address;
import com.thigas.quack.Domain.Factory.Interface.AddressFactory;
import com.thigas.quack.UseCase.Boundary.AddressInputBoundary;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.AddressMapper;
import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.PayloadUtil;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AddressService implements AddressInputBoundary {

    private final AddressDsGateway addressDsGateway;
    private final GenericPresenter genericPresenter;
    private final AddressFactory addressFactory;
    private final AddressMapper addressMapper;
    private final UserDsGateway userDsGateway;

    @Override
    public ResponseWrapper<GenericResponseModel> create(AddressCreateRequestModel addressCreateRequestModel) {
        UserRequestModel userDto = getUserById(addressCreateRequestModel.userId());

        Address address = createAddress(addressCreateRequestModel, userDto.id());

        if (!address.isValid() || !address.isCepValid()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Invalid address"), 400);
        }

        saveAddress(address);
        Map<String, Object> payload = PayloadUtil.createAddressPayload("Address created successfully");
        return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 201);
    }

    private UserRequestModel getUserById(Integer userId) {
        return userDsGateway.getById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    private Address createAddress(AddressCreateRequestModel addressCreateRequestModel, Integer userId) {
        return addressFactory.create(
                userId,
                addressCreateRequestModel.street(),
                addressCreateRequestModel.city(),
                addressCreateRequestModel.state(),
                addressCreateRequestModel.country(),
                addressCreateRequestModel.zipCode(),
                addressCreateRequestModel.number()
        );
    }

    private void saveAddress(Address address) {
        AddressRequestModel addressRequestModel = addressMapper.toDsModel(address);
        addressDsGateway.save(addressRequestModel);
    }

    @Override
    public ResponseWrapper<Optional<AddressInfoResponseModel>> getUserAddress(Integer userId, Integer addressId) {
        Optional<AddressInfoResponseModel> address = addressDsGateway.getUserAddress(userId, addressId);
        return new ResponseWrapper<>(address, 200);
    }

    @Override
    public ResponseWrapper<Iterable<AddressInfoResponseModel>> getAllUserAddresses(Integer userId) {
        Iterable<AddressInfoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
        return new ResponseWrapper<>(addresses, 200);
    }

    @Override
    public ResponseWrapper<GenericResponseModel> update(AddressRequestModel addressDtoRequest) {
        AddressInfoResponseModel existingAddress = getAddressById(addressDtoRequest.id());

        AddressRequestModel updatedAddress = updateAddressDetails(addressDtoRequest, existingAddress);

        addressDsGateway.update(updatedAddress);
        Map<String, Object> payload = PayloadUtil.createAddressPayload("Address updated successfully");
        return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 204);
    }

    private AddressInfoResponseModel getAddressById(Integer addressId) {
        return addressDsGateway.getById(addressId)
                .orElseThrow(() -> new EntityNotFoundException("Address not found"));
    }

    private AddressRequestModel updateAddressDetails(AddressRequestModel addressDtoRequest, AddressInfoResponseModel existingAddress) {
        return new AddressRequestModel(
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
    }

    @Override
    public ResponseWrapper<GenericResponseModel> delete(Integer id) {
        if (!addressDsGateway.findById(id)) {
            throw new NoSuchElementException("Address not found");
        }
        addressDsGateway.deleteById(id);
        Map<String, Object> payload = PayloadUtil.createAddressPayload("Address deleted successfully");
        return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 200);
    }
}