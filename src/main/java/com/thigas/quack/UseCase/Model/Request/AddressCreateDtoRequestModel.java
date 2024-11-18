package com.thigas.quack.UseCase.Model.Request;

public record AddressCreateDtoRequestModel(Integer userId, String street, String city, String state,
                                           String country, String zipCode, String number) {
}
