package com.thigas.quack.domain.repository;

import java.util.Optional;
import com.thigas.quack.domain.entity.TaskEntity;

public interface ITaskRepository {
    TaskEntity save(TaskEntity task);

    Optional<TaskEntity> findById(int id);

    Iterable<TaskEntity> findAll();

    void deleteById(int id);
}