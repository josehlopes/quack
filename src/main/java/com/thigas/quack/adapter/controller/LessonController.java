package com.thigas.quack.adapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.application.service.LessonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public ResponseEntity<Set<LessonDTO>> create(@RequestBody Set<LessonDTO> lessonDTOs) {
        Set<LessonDTO> createdLessons = lessonService.createLessons(lessonDTOs);
        return new ResponseEntity<>(createdLessons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getLessonById(@PathVariable Integer id) {
        return lessonService.getLessonById(id)
                .map(lessonDTO -> new ResponseEntity<>(lessonDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<LessonDTO>> getAllLessons() {
        Iterable<LessonDTO> lessons = lessonService.getAllLessons();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLesson(@PathVariable Integer id, @RequestBody LessonDTO lessonDTO) {
        if (id.equals(lessonDTO.getId())) {
            lessonService.updateLesson(lessonDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Integer id) {
        lessonService.deleteLesson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
