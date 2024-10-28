package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class RegisterUserDTO {
    private int id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private String bornAt;
    private String imagePath;

}
