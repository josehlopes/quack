package com.thigas.quack.Domain.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseType {
    SUCCESS("Success"),
    ERROR("Error");

    private final String typeOfResponse;
}