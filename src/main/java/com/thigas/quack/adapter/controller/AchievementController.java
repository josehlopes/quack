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
    public ResponseEntity<AchievementDTO> getById(@PathVariable Long id) {
        return achievementService.getById(id)
                .map(achievementDTO -> new ResponseEntity<>(achievementDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<AchievementDTO>> getAll() {
        Iterable<AchievementDTO> addresses = achievementService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody AchievementDTO achievementDTO) {
        if (id.equals(achievementDTO.getId())) {
            achievementService.update(achievementDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        achievementService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}