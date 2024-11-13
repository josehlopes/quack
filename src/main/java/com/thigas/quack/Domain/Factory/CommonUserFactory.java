package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.CommonUser;
import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String name, String phone, String email, String password, String cpf, LocalDate bornAt, String imagePath) {
        OffsetDateTime registerOn = OffsetDateTime.now();
        Status status = Status.ACTIVE;
        return new CommonUser(name, email, phone, email, password, cpf, bornAt, registerOn, imagePath, status);
    }
}
