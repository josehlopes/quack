package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Mapper.TaskMapper;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class TaskService {
    
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    
    private final TaskDsGateway taskDsGateway;
    private final GenericPresenter genericPresenter;
    private final TaskMapper taskMapper;
    
    public ResponseWrapper<GenericResponseModel> getById(int id) {
        try {
            Optional<TaskRequestModel> task = taskDsGateway.getTaskById(id);
            
            if (task.isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Task not found"), 404);
            }
            
            Map<String, Object> payload = Map.of("lesson", task.get());
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Task found", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting task by ID: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting task"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> getAll() {
        try {
            Iterable<TaskRequestModel> tasks = taskDsGateway.getAllTasks();
            Iterable<TaskRequestModel> taskList = StreamSupport.stream(tasks.spliterator(), false)
                    .collect(Collectors.toList());
            
            if (!taskList.iterator().hasNext()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("No tasks available"), 204);
            }
            
            Map<String, Object> payload = Map.of("tasks", taskList);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("All tasks retrieved", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting all tasks", e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting all tasks"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> existsById(int id) {
        try {
            boolean exists = taskDsGateway.existsById(id);
            
            if (!exists) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Task does not exist"), 404);
            }
            
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Task exists"), 200);
        } catch (Exception e) {
            logger.error("Error checking if task exists by ID: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error checking if task exists"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> getStepsByTaskId(int taskId) {
        try {
            Set<StepDataMapper> steps = taskDsGateway.getStepsByTaskId(taskId);
            
            if (steps.isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("No steps found for the given task"), 404);
            }
            
            Map<String, Object> payload = Map.of("steps", steps);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Steps retrieved successfully", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting steps by task ID: {}", taskId, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting steps"), 500);
        }
    }
}