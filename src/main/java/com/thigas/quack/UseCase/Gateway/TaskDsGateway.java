package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;

import java.util.Optional;

public interface TaskDsGateway {

    Optional<TaskRequestModel> getById(Integer id);
    boolean existsById(Integer id);
    Iterable<TaskRequestModel> getAll();
}