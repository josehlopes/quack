package com.thigas.quack.adapter.dto;

import lombok.Data;

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
    private String registerAt;
    private String imagePath;
    private int status;
}