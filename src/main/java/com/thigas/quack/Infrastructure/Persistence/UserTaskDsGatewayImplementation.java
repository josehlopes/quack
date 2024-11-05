package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import com.thigas.quack.Infrastructure.Entity.UserTaskDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaUserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserTaskDsGatewayImplementation implements UserTaskDsGateway {

    @Autowired
    private JpaUserTaskRepository userTaskModelRepository;

    @Override
    public void save(UserTaskDataMapper userTaskDataMapper) {
         userTaskModelRepository.save(userTaskDataMapper);
    }

    @Override
    public Optional<UserTaskDataMapper> findById(int id) {
        return userTaskModelRepository.findById(id);
    }

    @Override
    public Iterable<UserTaskDataMapper> findAll() {
        return userTaskModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userTaskModelRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return userTaskModelRepository.existsById(id);
    }
}