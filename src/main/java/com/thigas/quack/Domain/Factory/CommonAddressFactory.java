package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.Address;
import com.thigas.quack.Domain.Entity.CommonAddress;
import com.thigas.quack.Domain.Entity.User;

public class CommonAddressFactory implements AddressFactory {
    @Override
    public Address create(String street, String city, String state, String country, String zipCode, String number) {
        return new CommonAddress(null, null, street, city, state, country, zipCode, number, 1);
    }
}
