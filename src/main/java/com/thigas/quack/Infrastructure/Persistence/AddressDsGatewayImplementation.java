package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Entity.AddressDataMapper;
import com.thigas.quack.UseCase.Gateway.AddressDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AddressDsGatewayImplementation implements AddressDsGateway {

    @Autowired
    private JpaAddressRepository addressModelRepository;

    @Override
    public void save(AddressDataMapper addressDataMapper) {
         addressModelRepository.save(addressDataMapper);
    }

    @Override
    public Optional<AddressDataMapper> findById(int id) {
        return addressModelRepository.findById(id);
    }

    @Override
    public Iterable<AddressDataMapper> findAll() {
        return addressModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        addressModelRepository.deleteById(id);
    }
}
