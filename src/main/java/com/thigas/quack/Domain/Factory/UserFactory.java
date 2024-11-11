package com.thigas.quack.Domain.Factory;

import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface UserFactory {
    User create(String name, String phone, String email, String password, String cpf, LocalDate bornAt, String imagePath);
}
