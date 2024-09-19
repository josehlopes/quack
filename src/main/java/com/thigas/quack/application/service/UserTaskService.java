package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.adapter.mapper.UserTaskMapper;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.domain.repository.IUserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserTaskService {

    private final UserTaskMapper userTaskMapper = UserTaskMapper.INSTANCE;
    @Autowired
    private IUserTaskRepository userTaskRepository;

    public UserTaskDTO create(UserTaskDTO userTaskDTO) {
        UserTaskEntity userTask = userTaskMapper.dtoToEntity(userTaskDTO);
        UserTaskEntity toSaveRoadmapUser = userTaskRepository.save(userTask);
        return userTaskMapper.entityToDto(toSaveRoadmapUser);
    }

    public Optional<UserTaskDTO> getById(int id) {
        Optional<UserTaskEntity> userTask = userTaskRepository.findById(id);
        return userTask.map(userTaskMapper::entityToDto);
    }

    public Iterable<UserTaskDTO> getAll() {
        Iterable<UserTaskEntity> userTasks = userTaskRepository.findAll();
        return StreamSupport.stream(userTasks.spliterator(), false).map(userTaskMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(UserTaskDTO userTaskDTO) {
        UserTaskEntity userTask = userTaskMapper.dtoToEntity(userTaskDTO);
        userTaskRepository.save(userTask);
    }

    public void delete(int id) {
        userTaskRepository.deleteById(id);
    }
}