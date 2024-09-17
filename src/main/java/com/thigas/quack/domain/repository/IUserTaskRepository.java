package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.UserTaskEntity;

public interface IUserTaskRepository {
    UserTaskEntity save(UserTaskEntity userTask);

    Optional<UserTaskEntity> findById(int id);

    Iterable<UserTaskEntity> findAll();

    void deleteById(int id);
}