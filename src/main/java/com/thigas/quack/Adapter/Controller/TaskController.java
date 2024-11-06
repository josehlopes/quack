package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Model.Request.TaskDtoRequestModel;
import com.thigas.quack.UseCase.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TaskDtoRequestModel taskDtoRequest) {
        taskService.create(taskDtoRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDtoRequestModel> getById(@PathVariable Integer id) {
        return taskService.getById(id).map(taskDtoRequest -> new ResponseEntity<>(taskDtoRequest, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<TaskDtoRequestModel>> getAll() {
        Iterable<TaskDtoRequestModel> tasks = taskService.getAll();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody TaskDtoRequestModel taskDtoRequest) {
        if (id.equals(taskDtoRequest.id())) {
            taskService.update(taskDtoRequest);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        taskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}