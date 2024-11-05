package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record AddressDtoRequestModel(Integer id, Integer userId, String street, String city, String state, String country, String zipCode, String number, Integer status) {
}