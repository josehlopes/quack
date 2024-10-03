package com.thigas.quack.application.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
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

    @Autowired
    private ObjectMapper objectMapper;

    public TaskDTO create(TaskDTO taskDTO) {
        // Mapeia o DTO para o modelo de entidade
        TaskModel taskModel = taskMapper.dtoToModel(taskDTO, context);

        // Associa os steps à task
        Set<StepModel> stepEntities = new HashSet<>();
        for (Integer stepId : taskDTO.getSteps()) {
            Optional<StepModel> stepOpt = stepRepository.findById(stepId);
            stepOpt.ifPresent(stepEntities::add);
        }
        taskModel.setSteps(stepEntities);

        // Salva a task no repositório
        TaskModel savedTask = taskRepository.save(taskModel);

        // Retorna o DTO da task salva
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
        // Mapeia o DTO para o modelo de entidade
        TaskModel taskModel = taskMapper.dtoToModel(taskDTO, context);

        // Atualiza os steps associados à task
        Set<StepModel> stepEntities = new HashSet<>();
        for (Integer stepId : taskDTO.getSteps()) {
            Optional<StepModel> stepOpt = stepRepository.findById(stepId);
            stepOpt.ifPresent(stepEntities::add);
        }
        taskModel.setSteps(stepEntities);

        // Salva a task atualizada no repositório
        taskRepository.save(taskModel);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}