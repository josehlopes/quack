package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.ITaskModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImplementation implements ITaskRepository {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private ITaskModelRepository taskModelRepository;

    @Override
    @Transactional
    public TaskEntity save(TaskEntity taskEntity) {
        TaskModel taskModel = taskMapper.entityToModel(taskEntity);
        TaskModel savedTaskModel = taskModelRepository.save(taskModel);
        return taskMapper.modelToEntity(savedTaskModel);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return taskModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Optional<TaskEntity> findById(int id) {
        return taskModelRepository.findById(id).map(taskMapper::modelToEntity);
    }

    @Override
    @Transactional
    public Iterable<TaskEntity> findAll() {
        return taskModelRepository.findAll().stream().map(taskMapper::modelToEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        taskModelRepository.deleteById(id);
    }
}