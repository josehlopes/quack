package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private int id;
    private int user;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
    private int status;


}
