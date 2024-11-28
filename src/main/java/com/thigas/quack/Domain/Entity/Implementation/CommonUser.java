package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUser implements User {

    private Integer id;

    private String name;

    private String surname;

    private String fullName;

    private String username;

    private String phone;

    private String email;

    private String password;

    private String cpf;

    private LocalDate bornDate;

    private OffsetDateTime registerOn;

    private String imagePath;

    private Boolean isActive;

    @Override
    public Boolean passwordIsValid() {
        return password != null && password.length() >= 8 &&
                password.matches(".*[A-Z].*") && password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }
}
