package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.TaskDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskDsGateway taskDsGateway;

    public TaskService(TaskDsGateway taskDsGateway) {
        this.taskDsGateway = taskDsGateway;
    }

    public void create(TaskDtoRequestModel taskDtoRequest) {
        taskDsGateway.save(taskDtoRequest);
    }

    public Optional<TaskDtoRequestModel> getById(int id) {
        return taskDsGateway.findById(id);
    }

    public Iterable<TaskDtoRequestModel> getAll() {
        Iterable<TaskDtoRequestModel> tasks = taskDsGateway.findAll();
        return StreamSupport.stream(tasks.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(TaskDtoRequestModel taskDtoRequest) {
        TaskDtoRequestModel existingTask = taskDsGateway.findById(taskDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Task not found"));
        TaskDtoRequestModel updatedTask = new TaskDtoRequestModel(
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