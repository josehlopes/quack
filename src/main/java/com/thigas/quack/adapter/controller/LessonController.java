package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.application.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @Autowired
    private CycleAvoidingMappingContext context;

    @PostMapping
    public ResponseEntity<LessonDTO> create(@RequestBody LessonDTO lessonDTO) {
        LessonDTO createdLesson = lessonService.create(lessonDTO);
        return new ResponseEntity<>(createdLesson, HttpStatus.CREATED);
    }

    @PostMapping("/create-several")
    public ResponseEntity<Set<LessonDTO>> createAll(@RequestBody Set<LessonDTO> lessonDTOs) {
        Set<LessonDTO> createdLessons = lessonService.createAll(lessonDTOs, context);
        return new ResponseEntity<>(createdLessons, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDTO> getById(@PathVariable Integer id) {
        return lessonService.getById(id).map(lessonDTO -> new ResponseEntity<>(lessonDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<LessonDTO>> getAll() {
        Iterable<LessonDTO> lessons = lessonService.getAll();
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody LessonDTO lessonDTO) {
        if (id.equals(lessonDTO.getId())) {
            lessonService.update(lessonDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        lessonService.deleteLesson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
