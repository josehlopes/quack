package com.thigas.quack.UseCase.Model.Request;

public record AddressDsRequestModel(Integer id, Integer userId, String street, String city, String state,
                                    String country, String zipCode, String number, Boolean isActive) {
}