package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.UserTaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserTaskRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserTaskService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserTaskService.class);
    
    private final UserTaskDsGateway userTaskDsGateway;

    public void create(UserTaskRequestModel userTaskDtoRequest) {
        try {
            userTaskDsGateway.save(userTaskDtoRequest);
        } catch (Exception e) {
            logger.error("Error creating User-Task", e);
            throw new RuntimeException("Error creating User-Task");
        }
    }

    public Optional<UserTaskRequestModel> getById(int id) {
        try {
            return userTaskDsGateway.findById(id);
        } catch (Exception e) {
            logger.error("Error getting User-Task by ID: {}", id, e);
            return Optional.empty();
        }
    }

    public Iterable<UserTaskRequestModel> getAll() {
        try {
            Iterable<UserTaskRequestModel> userTasks = userTaskDsGateway.findAll();
            return StreamSupport.stream(userTasks.spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all User-Tasks", e);
            return Collections.emptyList();
        }
    }

    public void update(UserTaskRequestModel userTaskDtoRequest) {
        try {
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
        } catch (Exception e) {
            logger.error("Error updating User-Task with ID: {}", userTaskDtoRequest.id(), e);
            throw new RuntimeException("Error updating User-Task");
        }
    }

    public void delete(int id) {
        try {
            if (!userTaskDsGateway.existsById(id)) {
                throw new EntityNotFoundException("User task not found");
            }
            userTaskDsGateway.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting User-Task with ID: {}", id, e);
            throw new RuntimeException("Error deleting User-Task");
        }
    }
}