package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.application.service.AchievementService;

@RestController
@RequestMapping("/achievements")
public class AchievementController {

    @Autowired
    private AchievementService achievementService;

    @PostMapping
    public ResponseEntity<AchievementDTO> create(@RequestBody AchievementDTO achievementDTO) {
        AchievementDTO createdAchievement = achievementService.create(achievementDTO);
        return new ResponseEntity<>(createdAchievement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AchievementDTO> getById(@PathVariable Integer id) {
        return achievementService.getById(id)
                .map(achievementDTO -> new ResponseEntity<>(achievementDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<AchievementDTO>> getAll() {
        Iterable<AchievementDTO> achievements = achievementService.getAll();
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody AchievementDTO achievementDTO) {
        if (id.equals(achievementDTO.getId())) {
            achievementService.update(achievementDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        achievementService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}