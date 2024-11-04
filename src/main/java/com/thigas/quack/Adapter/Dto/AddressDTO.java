package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
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
