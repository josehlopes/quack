package com.thigas.quack.Domain.Utils;

import lombok.Getter;

@Getter
public enum Status {
    INACTIVE(0), ACTIVE(1), FINISHED(2), CANCELED(3), SKIPPED(4), UNLOCKED(5);

    private final int value;

    //TODO: Transformar enums em status apenas para roadmaps e usar boolean "enabled" para o usuário
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
