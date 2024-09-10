package com.thigas.quack.adapter.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thigas.quack.application.service.RoadmapService;
import com.thigas.quack.domain.entity.Roadmap;

@RestController
@RequestMapping("/roadmaps")
public class RoadmapController {
    @Autowired

    private RoadmapService roadmapService;

    @PostMapping
    public Roadmap createRoadmap(@RequestBody Roadmap roadmap) {
        return roadmapService.createRoadmap(roadmap);
    }

    @GetMapping("/{id}")
    public Optional<Roadmap> getRoadmapById(@PathVariable Long id) {
        return roadmapService.getRoadmapById(id);
    }

    @GetMapping
    public Iterable<Roadmap> getAllRoadmaps() {
        return roadmapService.getAllRoadmaps();
    }

    @PutMapping("/{id}")
    public void updateRoadmap(@PathVariable Long id, @RequestBody Roadmap roadmap) {
        roadmap.setId(id);
        roadmapService.updateRoadmap(roadmap);
    }

    @DeleteMapping("/{id}")
    public void deleteRoadmap(@PathVariable Long id) {
        roadmapService.deleteRoadmap(id);
    }
}