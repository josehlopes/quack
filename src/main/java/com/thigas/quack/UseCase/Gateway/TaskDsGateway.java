package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;

import java.util.Optional;

public interface TaskDsGateway {
    void save(TaskRequestModel task);

    Optional<TaskRequestModel> findById(int id);

    boolean existsById(int id);

    Iterable<TaskRequestModel> findAll();

    void deleteById(int id);
}