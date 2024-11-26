package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.Interface.Address;
import com.thigas.quack.Domain.Entity.Implementation.CommonAddress;

public class CommonAddressFactory implements AddressFactory {
    @Override
    public Address create(Integer userId, String street, String city, String state, String country, String zipCode, String number) {
        return new CommonAddress(null, userId, street, city, state, country, zipCode, number, true);
    }
}
