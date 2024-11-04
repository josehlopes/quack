package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserDTO {

    private String name;
    private String username;
    private String phone;
    private String email;
    private String cpf;
    private String imagePath;
}