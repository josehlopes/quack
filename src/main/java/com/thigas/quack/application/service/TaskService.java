package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
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
    private ILessonRepository lessonRepository;

    @Transactional
    public TaskDTO create(TaskDTO taskDTO) {
        TaskEntity taskEntity = taskMapper.dtoToEntity(taskDTO);
        Set<LessonEntity> lessonEntities = new HashSet<>();
        for (Integer lessonId : taskDTO.getLessonIds()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            lesson.ifPresent(lessonEntities::add);
        }
        taskEntity.setLessons(lessonEntities);
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