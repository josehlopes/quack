package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.adapter.mapper.UserTaskMapper;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.domain.repository.IUserTaskRepository;

@Service
public class UserTaskService {

    @Autowired
    private IUserTaskRepository userTaskRepository;
    private final UserTaskMapper userTaskMapper = UserTaskMapper.INSTANCE;

    public UserTaskDTO create(UserTaskDTO userTaskDTO) {
        // Converter DTO para entidade
        UserTaskEntity userTask = userTaskMapper.DtoToEntity(userTaskDTO);
        // Salvar a entidade
        UserTaskEntity toSaveRoadmapUser = userTaskRepository.save(userTask);
        // Converter entidade de volta para DTO
        return userTaskMapper.EntityToDto(toSaveRoadmapUser);
    }

    public Optional<UserTaskDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<UserTaskEntity> userTask = userTaskRepository.findById(id);
        // Converter a entidade para DTO
        return userTask.map(userTaskMapper::EntityToDto);
    }

    public Iterable<UserTaskDTO> getAll() {
        // Buscar todas as entidades
        Iterable<UserTaskEntity> userTasks = userTaskRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(userTasks.spliterator(), false)
                .map(userTaskMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(UserTaskDTO userTaskDTO) {
        // Converter DTO para entidade
        UserTaskEntity userTask = userTaskMapper.DtoToEntity(userTaskDTO);
        // Atualizar a entidade
        userTaskRepository.save(userTask);
    }

    public void delete(int id) {
        userTaskRepository.deleteById(id);
    }
}