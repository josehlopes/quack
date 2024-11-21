package com.thigas.quack.UseCase.Model.Request;

public record AddressCreateRequestModel(Integer userId, String street, String city, String state,
                                        String country, String zipCode, String number) {
}
