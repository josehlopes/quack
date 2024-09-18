package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.application.service.UserRoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roadmap-users")
public class UserRoadmapController {

    private final UserRoadmapService userRoadmapService;

    @Autowired
    public UserRoadmapController(UserRoadmapService userRoadmapService) {
        this.userRoadmapService = userRoadmapService;
    }

    @PostMapping
    public ResponseEntity<UserRoadmapDTO> create(@RequestBody UserRoadmapDTO userRoadmapDTO) {
        UserRoadmapDTO createdUserRoadmapDTO = userRoadmapService.create(userRoadmapDTO);
        return new ResponseEntity<>(createdUserRoadmapDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoadmapDTO> getById(@PathVariable Integer id) {
        return userRoadmapService.getById(id).map(userRoadmapDTO -> new ResponseEntity<>(userRoadmapDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<UserRoadmapDTO>> getAll() {
        Iterable<UserRoadmapDTO> userRoadmaps = userRoadmapService.getAll();
        return new ResponseEntity<>(userRoadmaps, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody UserRoadmapDTO userRoadmapDTO) {
        if (id.equals(userRoadmapDTO.getId())) {
            userRoadmapService.update(userRoadmapDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userRoadmapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
