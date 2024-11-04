package com.thigas.quack.Domain.Entity;

import com.thigas.quack.Domain.Utils.Status;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class CommonUser implements User {

    private Integer id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornDate;
    private OffsetDateTime registerOn;
    private String imagePath;
    private Status status;

    public CommonUser(Integer id, String name, String username,
                      String phone, String email, String password,
                      String cpf, LocalDate bornDate, OffsetDateTime registerOn, String imagePath, Status status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.bornDate = bornDate;
        this.registerOn = registerOn;
        this.imagePath = imagePath;
        this.status = status;
    }


    @Override
    public boolean passwordIsValid() {
        return password != null && password.length() >= 8;
    }
}
