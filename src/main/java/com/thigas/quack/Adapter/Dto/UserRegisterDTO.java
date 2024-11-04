package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

@Data
public class UserRegisterDTO {
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private String bornDate;
    private String imagePath;
}
