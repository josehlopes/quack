package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Gateway.TaskDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.TaskRequestModel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskDsGateway taskDsGateway;

    @GetMapping("/{id}")
    public ResponseEntity<TaskRequestModel> getById(@PathVariable Integer id) {
        try {
            return taskDsGateway.getById(id)
                    .map(roadmap -> new ResponseEntity<>(roadmap, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<TaskRequestModel>> getAll() {
        try {
            Iterable<TaskRequestModel> tasks = taskDsGateway.getAll();
            if (tasks != null) {
                return new ResponseEntity<>(tasks, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
