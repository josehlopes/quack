package com.thigas.quack.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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