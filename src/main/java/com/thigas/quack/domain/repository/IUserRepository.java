package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.UserModel;

import java.util.Optional;

public interface IUserRepository {

    UserModel save(UserModel user);

    Optional<UserModel> findById(int id);

    Boolean existsById(int id);

    Iterable<UserModel> findAll();

    void deleteById(int id);

    Optional<UserModel> findByEmail(String email);
}
