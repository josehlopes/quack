package com.thigas.quack.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornAt;
    private Double points;
    private LocalDateTime registerAt;
    private String imagePath;
}
