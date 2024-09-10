package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thigas.quack.application.service.RoadmapUserService;
import com.thigas.quack.domain.entity.RoadmapUser;

@RestController
@RequestMapping("/roadmap-users")
public class RoadmapUserController {

    @Autowired
    private RoadmapUserService roadmapUserService;

    @PostMapping
    public RoadmapUser createRoadmapUser(@RequestBody RoadmapUser roadmapUser) {
        return roadmapUserService.createRoadmapUser(roadmapUser);
    }

    @GetMapping
    public Iterable<RoadmapUser> getAllRoadmapUsers() {
        return roadmapUserService.getAllRoadmapUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteRoadmapUser(@PathVariable Long id) {
        roadmapUserService.deleteRoadmapUser(id);
    }
}
