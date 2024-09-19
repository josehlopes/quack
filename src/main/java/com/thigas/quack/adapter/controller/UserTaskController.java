package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.application.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-tasks")
public class UserTaskController {

    @Autowired
    private UserTaskService userTaskService;

    @PostMapping
    public ResponseEntity<UserTaskDTO> create(@RequestBody UserTaskDTO DTO) {
        UserTaskDTO createdUserTask = userTaskService.create(DTO);
        System.out.println(DTO);
        return new ResponseEntity<>(createdUserTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTaskDTO> getById(@PathVariable Integer id) {
        return userTaskService.getById(id).map(DTO -> new ResponseEntity<>(DTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserTaskDTO>> getAll() {
        Iterable<UserTaskDTO> userTasks = userTaskService.getAll();
        return new ResponseEntity<>(userTasks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserTaskDTO DTO) {
        if (id.equals(DTO.getId())) {
            userTaskService.update(DTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userTaskService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
