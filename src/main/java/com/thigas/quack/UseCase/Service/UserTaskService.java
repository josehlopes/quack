package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserTaskDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Entity.UserTaskDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserTaskDtoRequestModel;
import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserTaskService {

    @Autowired
    private UserTaskDsGateway userTaskRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public void create(UserTaskDTO userTaskDTO) {
        UserTaskDtoRequestModel userTaskDtoRequestModel = objectMapperService.toEntity(userTaskDTO);
        userTaskRepository.save(objectMapperService.toModel(userTaskDtoRequestModel));
    }


    public Optional<UserTaskDTO> getById(int id) {
        return userTaskRepository.findById(id)
                .map(objectMapperService::toDto);
    }


    public Iterable<UserTaskDTO> getAll() {
        Iterable<UserTaskDataMapper> userTasks = userTaskRepository.findAll();
        return StreamSupport.stream(userTasks.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }


    public void update(UserTaskDTO userTaskDTO) {
        UserTaskDataMapper existingUserTask = userTaskRepository.findById(userTaskDTO.getId())
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
