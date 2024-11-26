package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.Address;

public interface AddressFactory {
    Address create(Integer userId, String street, String city, String state, String country, String zipCode, String number);
}
