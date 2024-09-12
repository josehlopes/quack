package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.application.service.RoadmapService;

@RestController
@RequestMapping("/roadmaps")
public class RoadmapController {
    @Autowired

    private RoadmapService roadmapService;

    @PostMapping
    public ResponseEntity<RoadmapDTO> create(@RequestBody RoadmapDTO addressDTO) {
        RoadmapDTO createdRoadmap = roadmapService.create(addressDTO);
        return new ResponseEntity<>(createdRoadmap, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoadmapDTO> getById(@PathVariable Long id) {
        return roadmapService.getById(id)
                .map(addressDTO -> new ResponseEntity<>(addressDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<RoadmapDTO>> getAll() {
        Iterable<RoadmapDTO> addresses = roadmapService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RoadmapDTO addressDTO) {
        if (id.equals(addressDTO.getId())) {
            roadmapService.update(addressDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        roadmapService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}