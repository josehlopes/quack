package com.thigas.quack.UseCase.Model.Response;

public record AddressInfoDtoResponseModel(Integer id, String street, String city, String state,
                                          String country, String zipCode, String number) {
}
