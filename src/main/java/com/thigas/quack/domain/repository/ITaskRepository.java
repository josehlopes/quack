package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.TaskModel;

import java.util.Optional;

public interface ITaskRepository {
    TaskModel save(TaskModel task);

    Optional<TaskModel> findById(int id);

    Boolean existsById(int id);

    Iterable<TaskModel> findAll();

    void deleteById(int id);
}