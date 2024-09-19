package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.UserTaskEntity;

import java.util.Optional;

public interface IUserTaskRepository {
    UserTaskEntity save(UserTaskEntity userTask);

    Optional<UserTaskEntity> findById(int id);

    Iterable<UserTaskEntity> findAll();

    void deleteById(int id);
}