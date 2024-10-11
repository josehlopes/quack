package com.thigas.quack.domain.model;

import lombok.Getter;

@Getter
public enum Status {
    INACTIVE(0), ACTIVE(1), FINISHED(2), CANCELED(3), SKIPPED(4);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido para Status: " + value);
    }
}
