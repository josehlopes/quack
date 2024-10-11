package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;

import java.util.Optional;

public interface IUserTaskRepository {
    UserTaskModel save(UserTaskModel userTask);

    Optional<UserTaskModel> findById(int id);

    Iterable<UserTaskModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}