package com.thigas.quack.UseCase.Model.Request;

public record AddressDtoRequestModel(Integer id, Integer userId, String street, String city, String state,
                                     String country, String zipCode, String number, Integer status) {
}