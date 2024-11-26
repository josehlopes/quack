package com.thigas.quack.UseCase.Model.Response;

public record AddressInfoResponseModel(Integer id, String street, String city, String state,
                                       String country, String zipCode, String number) {
}
