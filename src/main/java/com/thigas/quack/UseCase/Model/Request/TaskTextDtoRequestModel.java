package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record TaskTextDtoRequestModel(String title, String description, String text) {
}
