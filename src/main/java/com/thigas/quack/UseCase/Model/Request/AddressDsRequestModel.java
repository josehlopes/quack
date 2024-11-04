package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDsRequestModel {

    private int id;
    private UserDsRequestModel user;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String number;
    private Status status;

}