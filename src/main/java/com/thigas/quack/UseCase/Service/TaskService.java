package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class TaskService {

    private final TaskDsGateway taskDsGateway;

    public void create(TaskRequestModel taskDtoRequest) {
        taskDsGateway.save(taskDtoRequest);
    }

    public Optional<TaskRequestModel> getById(int id) {
        return taskDsGateway.findById(id);
    }

    public Iterable<TaskRequestModel> getAll() {
        Iterable<TaskRequestModel> tasks = taskDsGateway.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(TaskRequestModel taskDtoRequest) {
        TaskRequestModel existingTask = taskDsGateway.findById(taskDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        TaskRequestModel updatedTask = new TaskRequestModel(
                taskDtoRequest.id(),
                taskDtoRequest.tasktext() != null ? taskDtoRequest.tasktext() : existingTask.tasktext(),
                taskDtoRequest.stepsIds() != null ? taskDtoRequest.stepsIds() : existingTask.stepsIds(),
                taskDtoRequest.imagePath() != null ? taskDtoRequest.imagePath() : existingTask.imagePath()
        );
        taskDsGateway.save(updatedTask);
    }

    public void delete(int id) {
        if (!taskDsGateway.existsById(id)) {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
        taskDsGateway.deleteById(id);
    }
}