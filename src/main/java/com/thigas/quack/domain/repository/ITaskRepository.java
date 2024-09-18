package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.TaskEntity;

import java.util.Optional;

public interface ITaskRepository {
    TaskEntity save(TaskEntity task);

    Optional<TaskEntity> findById(int id);

    Iterable<TaskEntity> findAll();

    void deleteById(int id);
}