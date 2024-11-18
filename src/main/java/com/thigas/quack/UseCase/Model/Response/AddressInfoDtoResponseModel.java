package com.thigas.quack.UseCase.Model.Response;

public record AddressInfoDtoResponseModel(String street, String city, String state,
                                          String country, String zipCode, String number) {
}
