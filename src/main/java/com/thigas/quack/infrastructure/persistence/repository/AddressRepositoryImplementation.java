package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.domain.entity.Address;
import com.thigas.quack.domain.entity.User;
import com.thigas.quack.domain.repository.IAddressRepository;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

@Repository
public class AddressRepositoryImplementation implements IAddressRepository {

    @Autowired
    private IAddressModelRepository addressModelRepository;

    @Override
    public Address save(Address address) {
        AddressModel addressModel = mapToAddressModel(address);
        return mapToAddress(addressModelRepository.save(addressModel));
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressModelRepository.findById(id).map(this::mapToAddress);
    }

    @Override
    public Iterable<Address> findAll() {
        return addressModelRepository.findAll().stream().map(this::mapToAddress).toList();
    }

    @Override
    public void deleteById(Long id) {
        addressModelRepository.deleteById(id);
    }

    private Address mapToAddress(AddressModel addressModel) {
        Address address = new Address();
        address.setId(addressModel.getId());
        address.setUser(mapToUser(addressModel.getUser()));
        address.setStreet(addressModel.getStreet());
        address.setCity(addressModel.getCity());
        address.setState(addressModel.getState());
        address.setCountry(addressModel.getCountry());
        address.setZipCode(addressModel.getZipCode());
        address.setNumber(addressModel.getNumber());
        return address;
    }

    private AddressModel mapToAddressModel(Address address) {
        AddressModel addressModel = new AddressModel();
        addressModel.setId(address.getId());
        addressModel.setUser(mapToUserModel(address.getUser()));
        addressModel.setStreet(address.getStreet());
        addressModel.setCity(address.getCity());
        addressModel.setState(address.getState());
        addressModel.setCountry(address.getCountry());
        addressModel.setZipCode(address.getZipCode());
        addressModel.setNumber(address.getNumber());
        return addressModel;
    }

    private User mapToUser(UserModel userModel) {
        User user = new User();
        user.setId(userModel.getId());
        return user;
    }

    private UserModel mapToUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        return userModel;
    }
}