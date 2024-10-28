package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

@Data
public class AddressDTO {
    private int id;
    private UserDTO user;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
    private Status status;
}
