package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.UserEntity;

import java.util.Optional;

public interface IUserRepository {
    UserEntity save(UserEntity user);

    Optional<UserEntity> findById(int id);

    Iterable<UserEntity> findAll();

    void deleteById(int id);

    Optional<UserEntity> findByEmail(String email);
}
