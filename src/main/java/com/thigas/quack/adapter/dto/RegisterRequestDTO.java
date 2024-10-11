package com.thigas.quack.adapter.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record RegisterRequestDTO(int id, String name, String username, String phone, String email, String password,
                                 String cpf, LocalDate bornAt, Double points, OffsetDateTime registerAt,
                                 String imagePath) {
}
