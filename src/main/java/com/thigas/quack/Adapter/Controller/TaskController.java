package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskDsGateway taskDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<TaskRequestModel> getById(@PathVariable Integer id) {
            return taskDsGateway.getTaskById(id)
                    .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<TaskRequestModel>> getAll() {
            Iterable<TaskRequestModel> tasks = taskDsGateway.getAllTasks();
            if (tasks != null) {
                return new ResponseEntity<>(tasks, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
    }

    @GetMapping("/{id}/steps")
    public ResponseEntity<Set<StepDataMapper>> getStepsByTaskId(@PathVariable Integer id) {
        try {
            Set<StepDataMapper> steps = taskDsGateway.getStepsByTaskId(id);

            if (steps.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(steps, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
