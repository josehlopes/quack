package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import com.thigas.quack.Adapter.Repository.TaskRepository;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Mapper.TaskMapper;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class TaskDsGatewayImplementation implements TaskDsGateway {

    private final TaskRepository repository;
    private final TaskMapper mapper;


    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<TaskRequestModel> getTaskById(Integer id) {
        Optional<TaskDataMapper> task = repository.getById(id);
        return task.map(mapper::toDsModel);
    }

    @Override
    public Iterable<TaskRequestModel> getAllTasks() {
        Iterable<TaskDataMapper> tasks = repository.getAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public Set<StepDataMapper> getStepsByTaskId(Integer taskId) {
        return repository.getById(taskId)
                .map(TaskDataMapper::getSteps)
                .orElse(Set.of());
    }
}