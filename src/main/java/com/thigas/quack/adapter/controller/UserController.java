package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.application.service.UserRoadmapService;
import com.thigas.quack.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoadmapService userRoadmapService;

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userService.create(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) {
        return userService.getById(id).map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> getAll() {
        Iterable<UserDTO> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        if (id.equals(userDTO.getId())) {
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

    @GetMapping("/status")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Sucesso!");
    }

    @PostMapping("/start-roadmap")
    public ResponseEntity<Void> startRoadmap(@RequestBody UserRoadmapDTO userRoadmapDTO) {
        try {
            if (userRoadmapService.startRoadmap(userRoadmapDTO.getUser(), userRoadmapDTO.getRoadmap())) {
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

