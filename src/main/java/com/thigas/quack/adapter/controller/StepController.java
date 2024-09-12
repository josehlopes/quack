package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.application.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping
    public ResponseEntity<StepDTO> create(@RequestBody StepDTO stepDTO) {
        StepDTO createdStep = stepService.create(stepDTO);
        return new ResponseEntity<>(createdStep, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StepDTO> getById(@PathVariable Integer id) {
        return stepService.getById(id)
                .map(stepDTO -> new ResponseEntity<>(stepDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<StepDTO>> getAll() {
        Iterable<StepDTO> step = stepService.getAll();
        return new ResponseEntity<>(step, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody StepDTO stepDTO) {
        if (id.equals(stepDTO.getId())) {
            stepService.update(stepDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        stepService.deleteStep(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
