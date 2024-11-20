package com.thigas.quack.UseCase.Model.Request.Address;

public record AddressDsDtoRequestModel(Integer id, Integer userId, String street, String city, String state,
                                       String country, String zipCode, String number, Boolean isActive) {
}