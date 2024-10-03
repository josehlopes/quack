package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.UserTaskMapper;
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
    private UserTaskMapper userTaskMapper;

    @Autowired
    CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();

    public UserTaskDTO create(UserTaskDTO userTaskDTO) {
        UserTaskModel userTaskModel = userTaskMapper.dtoToModel(userTaskDTO, new CycleAvoidingMappingContext());
        UserTaskModel savedUserTask = userTaskRepository.save(userTaskModel);
        return userTaskMapper.modelToDto(savedUserTask, context);
    }

    public Optional<UserTaskDTO> getById(int id) {
        Optional<UserTaskModel> userTaskOptional = userTaskRepository.findById(id);
        return userTaskOptional.map(userTask -> userTaskMapper.modelToDto(userTask, new CycleAvoidingMappingContext()));
    }

    public Iterable<UserTaskDTO> getAll() {
        Iterable<UserTaskModel> userTasks = userTaskRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(userTasks.spliterator(), false).map(userTask -> userTaskMapper.modelToDto(userTask, context))
                .collect(Collectors.toList());
    }

    public void update(UserTaskDTO userTaskDTO) {
        UserTaskModel existingUser = userTaskRepository.findById(userTaskDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        userTaskRepository.save(existingUser);
    }

    public void delete(int id) {
        userTaskRepository.deleteById(id);
    }
}