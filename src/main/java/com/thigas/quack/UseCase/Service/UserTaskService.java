package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserTaskDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserTaskService {

    private final UserTaskDsGateway userTaskDsGateway;

    public UserTaskService(UserTaskDsGateway userTaskDsGateway) {
        this.userTaskDsGateway = userTaskDsGateway;
    }


    public void create(UserTaskDtoRequestModel userTaskDtoRequest) {
        userTaskDsGateway.save(userTaskDtoRequest);
    }

    public Optional<UserTaskDtoRequestModel> getById(int id) {
        return userTaskDsGateway.findById(id);
    }

    public Iterable<UserTaskDtoRequestModel> getAll() {
        Iterable<UserTaskDtoRequestModel> userTasks = userTaskDsGateway.findAll();
        return StreamSupport.stream(userTasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserTaskDtoRequestModel userTaskDtoRequest) {
        UserTaskDtoRequestModel existingUserTask = userTaskDsGateway.findById(userTaskDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User task not found"));

        UserTaskDtoRequestModel updatedEntity = new UserTaskDtoRequestModel(
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