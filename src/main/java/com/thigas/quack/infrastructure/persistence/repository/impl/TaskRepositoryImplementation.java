package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
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
    private ITaskModelRepository taskModelRepository;
    
    @Override
    @Transactional
    public TaskModel save(TaskModel taskModel) {
        return taskModelRepository.save(taskModel);
    }

    @Override
    @Transactional
    public Boolean existsById(int id) {
        return taskModelRepository.existsById(id);
    }

    @Override
    @Transactional
    public Optional<TaskModel> findById(int id) {
        return taskModelRepository.findById(id);
    }


    @Override
    @Transactional
    public Iterable<TaskModel> findAll() {
        return taskModelRepository.findAll();
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        taskModelRepository.deleteById(id);
    }
}