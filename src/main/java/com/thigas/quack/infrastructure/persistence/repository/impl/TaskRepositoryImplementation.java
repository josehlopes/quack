package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.ITaskModelRepository;

@Repository
public class TaskRepositoryImplementation implements ITaskRepository {

    @Autowired
    private ITaskModelRepository taskModelRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    @Override
    public TaskEntity save(TaskEntity task) {
        TaskModel taskModel = taskMapper.EntityToModel(task);
        TaskModel savedTaskModel = taskModelRepository.save(taskModel);
        return taskMapper.ModelToEntity(savedTaskModel);
    }

    @Override
    public Optional<TaskEntity> findById(int id) {
        return taskModelRepository.findById(id).map(taskMapper::ModelToEntity);
    }

    @Override
    public Iterable<TaskEntity> findAll() {
        return taskModelRepository.findAll().stream()
                .map(taskMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        taskModelRepository.deleteById(id);
    }
}