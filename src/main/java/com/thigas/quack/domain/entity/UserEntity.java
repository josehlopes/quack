package com.thigas.quack.domain.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.thigas.quack.adapter.model.BaseEntity;

import com.thigas.quack.domain.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements BaseEntity {

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

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
