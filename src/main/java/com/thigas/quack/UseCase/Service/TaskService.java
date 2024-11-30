package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Mapper.LessonMapper;
import com.thigas.quack.UseCase.Mapper.TaskMapper;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class TaskService {

    private final TaskDsGateway taskDsGateway;
    private final GenericPresenter genericPresenter;
    private final TaskMapper taskMapper;


    public ResponseWrapper<GenericResponseModel> getById(int id) {
        Optional<TaskRequestModel> task = taskDsGateway.getById(id);

        if (task.isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Task not found"), 404);
        }

        Map<String, Object> payload = Map.of("lesson", task.get());
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Task found", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> getAll() {
        Iterable<TaskRequestModel> tasks = taskDsGateway.getAll();
        Iterable<TaskRequestModel> taskList = StreamSupport.stream(tasks.spliterator(), false)
                .collect(Collectors.toList());

        if (!taskList.iterator().hasNext()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("No tasks available"), 204);
        }

        Map<String, Object> payload = Map.of("tasks", taskList);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("All tasks retrieved", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> existsById(int id) {
        boolean exists = taskDsGateway.existsById(id);

        if (!exists) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Task does not exist"), 404);
        }

        return genericPresenter.prepareSuccessView(new GenericResponseModel("Task exists"), 200);
    }

}