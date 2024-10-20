package com.thigas.quack.domain.repository;

import com.thigas.quack.infrastructure.persistence.entity.UserStepModel;

import java.util.Optional;

public interface IUserStepRepository {
    UserStepModel save(UserStepModel userStep);

    Optional<UserStepModel> findById(int id);

    Iterable<UserStepModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}
