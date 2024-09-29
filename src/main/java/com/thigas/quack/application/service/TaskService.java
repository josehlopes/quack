package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;
    @Autowired
    private IStepRepository stepRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private CycleAvoidingMappingContext context;


    public TaskDTO create(TaskDTO taskDTO) {
        TaskEntity taskEntity = taskMapper.dtoToEntity(taskDTO, context);
        List<StepEntity> stepEntities = new ArrayList<>();
        for (Integer stepId : taskDTO.getSteps()) {
            Optional<StepEntity> task = stepRepository.findById(stepId);
            task.ifPresent(stepEntities::add);
        }
        taskEntity.setSteps(stepEntities);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return taskMapper.entityToDto(savedTask, context);
    }

    public Optional<TaskDTO> getById(int id) {
        Optional<TaskEntity> taskOpt = taskRepository.findById(id);
        return taskOpt.map(task -> taskMapper.entityToDto(task, new CycleAvoidingMappingContext()));
    }

    public Iterable<TaskDTO> getAll() {
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(task -> taskMapper.entityToDto(task, context))
                .collect(Collectors.toList());
    }

    public void update(TaskDTO taskDTO) {
        TaskEntity task = taskMapper.dtoToEntity(taskDTO, context);
        taskRepository.save(task);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}