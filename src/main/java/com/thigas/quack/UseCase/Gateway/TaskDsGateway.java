package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.TaskDataMapper;

import java.util.Optional;

public interface TaskDsGateway {
    void save(TaskDataMapper task);
    Optional<TaskDataMapper> findById(int id);
    boolean existsById(int id);
    Iterable<TaskDataMapper> findAll();
    void deleteById(int id);
}