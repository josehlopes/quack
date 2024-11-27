// src/main/java/com/thigas/quack/UseCase/Model/Response/GenericResponseModel.java
package com.thigas.quack.UseCase.Model.Response;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;

public record GenericResponseModel(String message, Map<String, Object> payload) {

    public GenericResponseModel(String message) {
        this(message, null);
    }

    public GenericResponseModel(Map<String, Object> payload) {
        this(null, payload);
    }

    public GenericResponseModel() {
        this(null, null);
    }

    @JsonCreator
    public GenericResponseModel(String message, Map<String, Object> payload) {
        if (message != null && message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be blank");
        }
        this.message = message;
        this.payload = payload;
    }
}