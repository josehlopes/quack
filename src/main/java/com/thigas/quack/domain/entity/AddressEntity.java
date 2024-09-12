package com.thigas.quack.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressEntity {

    private int id;
    private UserEntity user;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
}