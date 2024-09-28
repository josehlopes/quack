package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.IStepRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskMapper taskMapper = TaskMapper.INSTANCE;
    @Autowired
    private ITaskRepository taskRepository;
    @Autowired
    private IStepRepository stepRepository;

    public TaskDTO create(TaskDTO taskDTO) {
        TaskEntity taskEntity = taskMapper.dtoToEntity(taskDTO);
        Set<StepEntity> stepEntities = new HashSet<>();
        for (Integer stepId : taskDTO.getSteps()) {
            Optional<StepEntity> lesson = stepRepository.findById(stepId);
            lesson.ifPresent(stepEntities::add);
        }
        taskEntity.setSteps(stepEntities);
        TaskEntity savedTask = taskRepository.save(taskEntity);
        return taskMapper.entityToDto(savedTask);
    }

    public Optional<TaskDTO> getById(int id) {
        Optional<TaskEntity> step = taskRepository.findById(id);
        return step.map(taskMapper::entityToDto);
    }

    public Iterable<TaskDTO> getAll() {
        Iterable<TaskEntity> steps = taskRepository.findAll();
        return StreamSupport.stream(steps.spliterator(), false).map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(TaskDTO taskDTO) {
        TaskEntity step = taskMapper.dtoToEntity(taskDTO);
        taskRepository.save(step);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}