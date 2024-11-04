package com.thigas.quack.Adapter.Dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ErrorDTO {

    private String message;
    private LocalDateTime timestamp;
    private int status;

    public ErrorDTO(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
