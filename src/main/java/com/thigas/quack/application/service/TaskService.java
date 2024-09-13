package com.thigas.quack.application.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.adapter.mapper.LessonMapper;
import com.thigas.quack.adapter.mapper.TaskMapper;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.repository.ILessonRepository;
import com.thigas.quack.domain.repository.ITaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private ILessonRepository lessonRepository;

    private final TaskMapper taskMapper = TaskMapper.INSTANCE;
    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    @Transactional
    public TaskDTO create(TaskDTO taskDTO) {
        // Converter DTO para entidade
        TaskEntity taskEntity = taskMapper.DtoToEntity(taskDTO);

        // Criar um conjunto para armazenar as lições
        Set<LessonEntity> lessonEntities = new HashSet<>();

        // Iterar sobre todos os IDs de lições
        for (Integer lessonId : taskDTO.getLessonIds()) {
            Optional<LessonEntity> lesson = lessonRepository.findById(lessonId);
            lesson.ifPresent(lessonEntities::add); // Adiciona a lição ao conjunto se estiver presente
        }

        // Definir as lições na entidade
        taskEntity.setLessons(lessonEntities);

        // Persistir a entidade
        TaskEntity savedTask = taskRepository.save(taskEntity);

        // Converter a entidade salva de volta para DTO
        return taskMapper.EntityToDto(savedTask);
    }

    public Optional<TaskDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<TaskEntity> step = taskRepository.findById(id);
        // Converter a entidade para DTO
        return step.map(taskMapper::EntityToDto);
    }

    public Iterable<TaskDTO> getAll() {
        // Buscar todas as entidades
        Iterable<TaskEntity> steps = taskRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(steps.spliterator(), false)
                .map(taskMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(TaskDTO taskDTO) {
        // Converter DTO para entidade
        TaskEntity step = taskMapper.DtoToEntity(taskDTO);
        // Atualizar a entidade
        taskRepository.save(step);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}