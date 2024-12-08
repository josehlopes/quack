package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserTaskDataMapper;
import com.thigas.quack.Adapter.Repository.JpaUserTaskRepository;
import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.UserTaskRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserTaskDsGatewayImplementation implements UserTaskDsGateway {

    private final JpaUserTaskRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserTaskRequestModel userTaskDtoRequest) {
        UserTaskDataMapper toSaveUserTask = mapper.mapUserTaskDtoRequestToDataMapper(userTaskDtoRequest);
        repository.save(toSaveUserTask);
    }

    @Override
    public Optional<UserTaskRequestModel> findById(Integer id) {
        Optional<UserTaskDataMapper> userTask = repository.findById(id);
        return userTask.map(mapper::mapUserTaskDataMapperToDtoRequest);
    }

    @Override
    public List<UserTaskRequestModel> findAll() {
        List<UserTaskDataMapper> userTasks = repository.findAll();
        return userTasks.stream()
                .map(mapper::mapUserTaskDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}