package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.Address;

public interface AddressFactory {
    Address create(Integer userId, String street, String city, String state, String country, String zipCode, String number);
}
