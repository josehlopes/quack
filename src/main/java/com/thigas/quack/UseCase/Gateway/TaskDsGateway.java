package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.TaskDtoRequestModel;

import java.util.Optional;

public interface TaskDsGateway {
    void save(TaskDtoRequestModel task);

    Optional<TaskDtoRequestModel> findById(int id);

    boolean existsById(int id);

    Iterable<TaskDtoRequestModel> findAll();

    void deleteById(int id);
}