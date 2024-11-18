package com.thigas.quack.UseCase.Model.Response;

import com.thigas.quack.Domain.Utils.ResponseType;

public record ResultDtoResponseModel(String message, Integer code, ResponseType responseType) {
}
