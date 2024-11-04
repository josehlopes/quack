package com.thigas.quack.UseCase.Model.Request;


import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDsRequestModel {

    private int id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornDate;
    private OffsetDateTime registerOn;
    private String imagePath;
    private Status status;

}
