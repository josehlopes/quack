package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.domain.repository.IUserTaskRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserTaskService {

    @Autowired
    private IUserTaskRepository userTaskRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public UserTaskDTO create(UserTaskDTO userTaskDTO) {
        UserTaskEntity userTaskEntity = objectMapperService.toEntity(userTaskDTO);
        UserTaskModel savedUserTask = userTaskRepository.save(objectMapperService.toModel(userTaskEntity));
        return objectMapperService.toDto(savedUserTask);
    }


    public Optional<UserTaskDTO> getById(int id) {
        return userTaskRepository.findById(id)
                .map(objectMapperService::toDto);
    }


    public Iterable<UserTaskDTO> getAll() {
        Iterable<UserTaskModel> userTasks = userTaskRepository.findAll();
        return StreamSupport.stream(userTasks.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserTaskDTO userTaskDTO) {
        UserTaskModel existingUserTask = userTaskRepository.findById(userTaskDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User task not found"));

        if (userTaskDTO.getId() != 0) {
            existingUserTask.setId(userTaskDTO.getId());
        }

        userTaskRepository.save(existingUserTask);
    }

    public void delete(int id) {
        if (!userTaskRepository.existsById(id)) {
            throw new EntityNotFoundException("User task not found");
        }
        userTaskRepository.deleteById(id);
    }
}
