package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.application.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/steps")
public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping
    public ResponseEntity<StepDTO> create(@RequestBody StepDTO DTO) {
        StepDTO createdStepDTO = stepService.create(DTO);
        return new ResponseEntity<>(createdStepDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StepDTO> getById(@PathVariable Integer id) {
        return stepService.getById(id)
                .map(DTO -> new ResponseEntity<>(DTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<StepDTO>> getAll() {
        Iterable<StepDTO> steps = stepService.getAll();
        return new ResponseEntity<>(steps, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody StepDTO DTO) {
        if (id.equals(DTO.getId())) {
            stepService.update(DTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        stepService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}