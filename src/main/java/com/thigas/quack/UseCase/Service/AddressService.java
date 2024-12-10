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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class AddressService implements AddressInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    
    private final AddressDsGateway addressDsGateway;
    private final GenericPresenter genericPresenter;
    private final AddressFactory addressFactory;
    private final AddressMapper addressMapper;
    private final UserDsGateway userDsGateway;
    
    @Override
    public ResponseWrapper<GenericResponseModel> createAddress(AddressCreateRequestModel addressCreateRequestModel) {
        try {
            UserRequestModel userDto = getUserById(addressCreateRequestModel.userId());
            
            Address address = createAddress(addressCreateRequestModel, userDto.id());
            
            if (!address.isValid() || !address.isCepValid()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Invalid address"), 400);
            }
            
            saveAddress(address);
            Map<String, Object> payload = PayloadUtil.createAddressPayload("Address created successfully");
            return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 201);
        } catch (Exception e) {
            logger.error("Error creating address", e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error creating address"), 500);
        }
    }
    
    private UserRequestModel getUserById(Integer userId) {
        try {
            return userDsGateway.getUserById(userId)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));
        } catch (EntityNotFoundException e) {
            logger.error("User not found: {}", userId, e);
            throw e;
        }
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
        addressDsGateway.saveAddress(addressRequestModel);
    }
    
    public ResponseWrapper<Optional<AddressInfoResponseModel>> getUserAddress(Integer userId, Integer addressId) {
        try {
            Optional<AddressInfoResponseModel> address = addressDsGateway.getUserAddress(userId, addressId);
            return new ResponseWrapper<>(address, 200);
        } catch (Exception e) {
            logger.error("Error getting user address: userId={}, addressId={}", userId, addressId, e);
            return new ResponseWrapper<>(Optional.empty(), 500);
        }
    }
    
    public ResponseWrapper<Iterable<AddressInfoResponseModel>> getAllUserAddresses(Integer userId) {
        try {
            Iterable<AddressInfoResponseModel> addresses = addressDsGateway.getAllUserAddresses(userId);
            return new ResponseWrapper<>(addresses, 200);
        } catch (Exception e) {
            logger.error("Error getting all user addresses: {}", userId, e);
            return new ResponseWrapper<>(Collections.emptyList(), 500);
        }
    }
    
    @Override
    public ResponseWrapper<GenericResponseModel> updateAddress(AddressRequestModel addressDtoRequest) {
        try {
            AddressInfoResponseModel existingAddress = getAddressById(addressDtoRequest.id());
            
            AddressRequestModel updatedAddress = updateAddressDetails(addressDtoRequest, existingAddress);
            
            addressDsGateway.updateAddress(updatedAddress);
            Map<String, Object> payload = PayloadUtil.createAddressPayload("Address updated successfully");
            return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 204);
        } catch (Exception e) {
            logger.error("Error updating address: {}", addressDtoRequest.id(), e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error updating address"), 500);
        }
    }
    
    private AddressInfoResponseModel getAddressById(Integer addressId) {
        try {
            return addressDsGateway.getById(addressId)
                    .orElseThrow(() -> new EntityNotFoundException("Address not found"));
        } catch (EntityNotFoundException e) {
            logger.error("Address not found: {}", addressId, e);
            throw e;
        }
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
    public ResponseWrapper<GenericResponseModel> deleteAddress(Integer id) {
        try {
            if (!addressDsGateway.existsById(id)) {
                throw new NoSuchElementException("Address not found");
            }
            addressDsGateway.deleteById(id);
            Map<String, Object> payload = PayloadUtil.createAddressPayload("Address deleted successfully");
            return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 200);
        } catch (Exception e) {
            logger.error("Error deleting address: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error deleting address"), 500);
        }
    }

//    public ResponseWrapper<GenericResponseModel> deactivateAddressByUserId(Integer userId, Integer addressId) {
//        try {
//            Optional<AddressInfoResponseModel> addressOptional = addressDsGateway.getUserAddress(userId, addressId);
//
//            if (addressOptional.isEmpty()) {
//                return genericPresenter.prepareFailView(
//                        new GenericResponseModel("Address not found for the given user and address ID"),
//                        404
//                );
//            }
//
//            AddressInfoResponseModel address = addressOptional.get();
//
//            AddressRequestModel updatedAddress = new AddressRequestModel(
//                    address.id(),
//                    address.userId(),
//                    address.street(),
//                    address.city(),
//                    address.state(),
//                    address.country(),
//                    address.zipCode(),
//                    address.number(),
//                    false
//            );
//
//            boolean isUpdated = addressDsGateway.updateAddress(updatedAddress);
//
//            if (!isUpdated) {
//                return genericPresenter.prepareFailView(
//                        new GenericResponseModel("Failed to deactivate address"),
//                        500
//                );
//            }
//
//            Map<String, Object> payload = PayloadUtil.createAddressPayload("Address deactivated successfully");
//            return genericPresenter.prepareSuccessView(new GenericResponseModel(payload), 200);
//
//        } catch (Exception e) {
//            logger.error("Error deactivating address for userId={}, addressId={}", userId, addressId, e);
//            return genericPresenter.prepareFailView(
//                    new GenericResponseModel("Error deactivating address"),
//                    500
//            );
//        }
//    }


}