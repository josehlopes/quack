package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.UserEntity;

public interface IUserRepository {
    UserEntity save(UserEntity user);

    Optional<UserEntity> findById(Long id);

    Iterable<UserEntity> findAll();

    void deleteById(Long id);
}
