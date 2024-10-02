package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.TaskMapper;
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
    private TaskMapper taskMapper;

    @Autowired
    private CycleAvoidingMappingContext context;


    public TaskDTO create(TaskDTO taskDTO) {
        TaskModel taskModel = taskMapper.dtoToModel(taskDTO, context);
        Set<StepModel> stepEntities = new HashSet<>();
        for (Integer stepId : taskDTO.getSteps()) {
            Optional<StepModel> task = stepRepository.findById(stepId);
            task.ifPresent(stepEntities::add);
        }
        taskModel.setSteps(stepEntities);
        TaskModel savedTask = taskRepository.save(taskModel);
        return taskMapper.modelToDto(savedTask, context);
    }

    public Optional<TaskDTO> getById(int id) {
        Optional<TaskModel> taskOpt = taskRepository.findById(id);
        return taskOpt.map(task -> taskMapper.modelToDto(task, new CycleAvoidingMappingContext()));
    }

    public Iterable<TaskDTO> getAll() {
        Iterable<TaskModel> tasks = taskRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(tasks.spliterator(), false)
                .map(task -> taskMapper.modelToDto(task, context))
                .collect(Collectors.toSet());
    }

    public void update(TaskDTO taskDTO) {
        TaskModel task = taskMapper.dtoToModel(taskDTO, context);
        taskRepository.save(task);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}