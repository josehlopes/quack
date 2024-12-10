package com.thigas.quack.UseCase.Model.Response;

public record AddressInfoResponseModel(Integer id, Integer userId, String street, String city, String state,
                                       String country, String zipCode, String number) {
}
