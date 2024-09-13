package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.application.service.UserRoadmapService;

@RestController
@RequestMapping("/roadmap-users")
public class UserRoadmapController {

    @Autowired
    private UserRoadmapService roadmapUserService;

    @PostMapping
    public ResponseEntity<RoadmapUserDTO> create(@RequestBody RoadmapUserDTO roadmapUserDTO) {
        RoadmapUserDTO createdRoadmapUser = roadmapUserService.create(roadmapUserDTO);
        return new ResponseEntity<>(createdRoadmapUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapUserDTO> getById(@PathVariable Integer id) {
        return roadmapUserService.getById(id)
                .map(roadmapUserDTO -> new ResponseEntity<>(roadmapUserDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<RoadmapUserDTO>> getAll() {
        Iterable<RoadmapUserDTO> userRoadmaps = roadmapUserService.getAll();
        return new ResponseEntity<>(userRoadmaps, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody RoadmapUserDTO roadmapUserDTO) {
        if (id.equals(roadmapUserDTO.getId())) {
            roadmapUserService.update(roadmapUserDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        roadmapUserService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
