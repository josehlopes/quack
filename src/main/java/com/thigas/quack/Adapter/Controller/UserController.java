package com.thigas.quack.Adapter.Controller;

import com.thigas.quack.UseCase.Boundary.UserInputBoundary;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRegisterDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDtoRequestModel;
import com.thigas.quack.UseCase.Service.UserRoadmapService;
import com.thigas.quack.UseCase.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    final UserInputBoundary userInput;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoadmapService userRoadmapService;

    public UserController(UserInputBoundary userInput) {
        this.userInput = userInput;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserRegisterDtoRequestModel userRequest) {
        userInput.create(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDtoRequestModel> getById(@PathVariable Integer id) {
        return userService.getById(id).map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDtoRequestModel>> getAll() {
        Iterable<UserDtoRequestModel> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserDtoRequestModel userDTO) {
        if (id.equals(userDTO.id())) {
            userService.update(userDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/start-roadmap")
    public ResponseEntity<Void> startRoadmap(@RequestBody UserRoadmapDtoRequestModel userRoadmapDTO) {
        try {
            if (userRoadmapService.startRoadmap(userRoadmapDTO.userId(), userRoadmapDTO.roadmapId())) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/end-roadmap/{id}")
    public ResponseEntity<Void> endRoadmap(@PathVariable Integer id) {
        try {
            if (id == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            if (userRoadmapService.endRoadmap(id)) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}

