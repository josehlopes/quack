package com.thigas.quack.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.domain.repository.IAddressRepository;

@Service
public class AddressService {

    @Autowired
    private IAddressRepository addressRepository;

    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepository.findById(id);
    }

    public Iterable<Address> getAllAddresss() {
        return addressRepository.findAll();
    }

    // Atualiza um Address
    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

}