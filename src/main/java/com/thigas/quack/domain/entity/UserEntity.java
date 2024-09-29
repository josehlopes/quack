package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.thigas.quack.domain.model.Status;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

    private int id;
    private String name;
    private String username;
    private String phone;
    private String email;
    private String password;
    private String cpf;
    private LocalDate bornAt;
    private Double points;
    private OffsetDateTime registerAt;
    private String imagePath;
    private Status status;

}
