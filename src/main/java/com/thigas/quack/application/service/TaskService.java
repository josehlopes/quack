package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private IStepRepository stepRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public TaskDTO create(TaskDTO taskDTO) {
        TaskModel taskModel = objectMapperService.toModel(taskDTO);
        Set<StepModel> stepEntities = new HashSet<>();

        for (Integer stepId : taskDTO.getSteps()) {
            stepRepository.findById(stepId).ifPresent(stepEntities::add);
        }

        taskModel.setSteps(stepEntities);
        TaskModel savedTask = taskRepository.save(taskModel);
        return objectMapperService.toDto(savedTask);
    }

    public Optional<TaskDTO> getById(int id) {
        return taskRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<TaskDTO> getAll() {
        Iterable<TaskModel> tasks = taskRepository.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toSet());
    }

    public void update(TaskDTO taskDTO) {
        TaskModel taskModel = objectMapperService.toModel(taskDTO);
        taskRepository.save(taskModel);
    }

    public void delete(int id) {
        if (!taskRepository.existsById(id)) {
            throw new IllegalArgumentException("Task não encontrada com id: " + id);
        }
        taskRepository.deleteById(id);
    }
}
