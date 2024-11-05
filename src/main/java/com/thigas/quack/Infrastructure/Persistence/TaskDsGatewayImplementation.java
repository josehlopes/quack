package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Entity.TaskDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaTaskRepository;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import jakarta.transaction.Transactional;

import java.util.Optional;

public class TaskDsGatewayImplementation implements TaskDsGateway {


    final JpaTaskRepository taskModelRepository;

    public TaskDsGatewayImplementation(JpaTaskRepository taskModelRepository) {
        this.taskModelRepository = taskModelRepository;
    }

    @Override
    @Transactional
    public void save(TaskDataMapper taskDataMapper) {
        taskModelRepository.save(taskDataMapper);
    }

    @Override
    @Transactional
    public boolean existsById(int id) {
        return taskModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Optional<TaskDataMapper> findById(int id) {
        return taskModelRepository.findById(id);
    }


    @Override
    @Transactional
    public Iterable<TaskDataMapper> findAll() {
        return taskModelRepository.findAll();
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        taskModelRepository.deleteById(id);
    }
}