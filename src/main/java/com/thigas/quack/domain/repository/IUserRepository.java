package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.User;

public interface IUserRepository {
    User save(User user);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    void deleteById(Long id);
}
