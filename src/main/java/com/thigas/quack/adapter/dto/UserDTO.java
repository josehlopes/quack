package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserDTO {

    private int id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private String bornAt;
    private Double points;
    private OffsetDateTime registerAt;
    private String imagePath;
    private Status status;
}