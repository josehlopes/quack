package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import com.thigas.quack.Adapter.Repository.TaskRepository;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class TaskDsGatewayImplementation implements TaskDsGateway {

    private final TaskRepository repository;
    private final MapStructMapper mapper;


    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<TaskRequestModel> getById(Integer id) {
        Optional<TaskDataMapper> task = repository.getById(id);
        return task.map(mapper::mapTaskDataMapperToDtoRequest);
    }

    @Override
    public Iterable<TaskRequestModel> getAll() {
        Iterable<TaskDataMapper> tasks = repository.getAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(mapper::mapTaskDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

}