package com.thigas.quack.UseCase.Model.Request.Address;

public record AddressCreateDtoRequestModel(Integer userId, String street, String city, String state,
                                           String country, String zipCode, String number) {
}
