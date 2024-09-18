package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.application.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roadmaps")
public class RoadmapController {
    @Autowired

    private RoadmapService roadmapService;

    @PostMapping
    public ResponseEntity<RoadmapDTO> create(@RequestBody RoadmapDTO DTO) {
        RoadmapDTO createdRoadmap = roadmapService.create(DTO);
        return new ResponseEntity<>(createdRoadmap, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapDTO> getById(@PathVariable Integer id) {
        return roadmapService.getById(id)
                .map(addressDTO -> new ResponseEntity<>(addressDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<RoadmapDTO>> getAll() {
        Iterable<RoadmapDTO> roadmaps = roadmapService.getAll();
        return new ResponseEntity<>(roadmaps, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody RoadmapDTO addressDTO) {
        if (id.equals(addressDTO.getId())) {
            roadmapService.update(addressDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        roadmapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}