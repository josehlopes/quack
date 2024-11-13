package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.TaskDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaTaskRepository;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.TaskDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class TaskDsGatewayImplementation implements TaskDsGateway {

    private final JpaTaskRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(TaskDtoRequestModel taskDtoRequest) {
        TaskDataMapper toSaveTask = mapper.mapTaskDtoRequestToDataMapper(taskDtoRequest);
        repository.save(toSaveTask);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<TaskDtoRequestModel> findById(int id) {
        Optional<TaskDataMapper> task = repository.findById(id);
        return task.map(mapper::mapTaskDataMapperToDtoRequest);
    }

    @Override
    public Iterable<TaskDtoRequestModel> findAll() {
        Iterable<TaskDataMapper> tasks = repository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(mapper::mapTaskDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}