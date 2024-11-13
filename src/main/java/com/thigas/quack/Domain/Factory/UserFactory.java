package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.User;

import java.time.LocalDate;

public interface UserFactory {
    User create(String name, String phone, String email, String password, String cpf, LocalDate bornAt, String imagePath);
}
