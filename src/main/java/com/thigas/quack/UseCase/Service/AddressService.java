package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.UseCase.Model.Request.AddressDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AddressService {

    private final AddressDsGateway addressDsGateway;

    public void create(AddressDtoRequestModel addressDtoRequest) {
        addressDsGateway.save(addressDtoRequest);
    }

    public Optional<AddressDtoRequestModel> getById(int id) {
        return addressDsGateway.findById(id);
    }

    public Iterable<AddressDtoRequestModel> getAll() {
        Iterable<AddressDtoRequestModel> addresses = addressDsGateway.findAll();
        return StreamSupport.stream(addresses.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(AddressDtoRequestModel addressDtoRequest) {
        AddressDtoRequestModel existingAddress = addressDsGateway.findById(addressDtoRequest.id())
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
                addressDtoRequest.status() != null ? addressDtoRequest.status() : existingAddress.status()
        );
        addressDsGateway.save(updatedAddress);
    }

    public void delete(int id) {
        addressDsGateway.deleteById(id);
    }
}
