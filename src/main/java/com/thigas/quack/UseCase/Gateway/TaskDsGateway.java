package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;

import java.util.Optional;
import java.util.Set;

public interface TaskDsGateway {

    Optional<TaskRequestModel> getTaskById(Integer id);
    Boolean existsById(Integer id);
    Iterable<TaskRequestModel> getAllTasks();
    Set<StepDataMapper> getStepsByTaskId(Integer taskId);
}