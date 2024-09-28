package com.thigas.quack.domain.repository;

import com.github.javafaker.Bool;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;

import java.util.Optional;

public interface IUserRepository {
    UserModel save(UserModel user);

    Optional<UserModel> findById(int id);

    Iterable<UserModel> findAll();

    void deleteById(int id);

    Boolean existsById(int id);

    Optional<UserModel> findByEmail(String email);
}
