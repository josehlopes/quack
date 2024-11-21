package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserTaskRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserTaskService {

    private final UserTaskDsGateway userTaskDsGateway;

    public void create(UserTaskRequestModel userTaskDtoRequest) {
        userTaskDsGateway.save(userTaskDtoRequest);
    }

    public Optional<UserTaskRequestModel> getById(int id) {
        return userTaskDsGateway.findById(id);
    }

    public Iterable<UserTaskRequestModel> getAll() {
        Iterable<UserTaskRequestModel> userTasks = userTaskDsGateway.findAll();
        return StreamSupport.stream(userTasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserTaskRequestModel userTaskDtoRequest) {
        UserTaskRequestModel existingUserTask = userTaskDsGateway.findById(userTaskDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User task not found"));

        UserTaskRequestModel updatedEntity = new UserTaskRequestModel(
                userTaskDtoRequest.id(),
                userTaskDtoRequest.userId() != null ? userTaskDtoRequest.userId() : existingUserTask.userId(),
                userTaskDtoRequest.taskId() != null ? userTaskDtoRequest.taskId() : existingUserTask.taskId(),
                userTaskDtoRequest.status() != null ? userTaskDtoRequest.status() : existingUserTask.status(),
                userTaskDtoRequest.imagePath() != null ? userTaskDtoRequest.imagePath() : existingUserTask.imagePath()
        );

        userTaskDsGateway.save(updatedEntity);
    }

    public void delete(int id) {
        if (!userTaskDsGateway.existsById(id)) {
            throw new EntityNotFoundException("User task not found");
        }
        userTaskDsGateway.deleteById(id);
    }
}