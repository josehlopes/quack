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

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.application.service.StepService;

@RestController
@RequestMapping("/steps")
public class StepController {

    @Autowired
    private StepService stepService;

    @PostMapping
    public ResponseEntity<StepDTO> create(@RequestBody StepDTO stepDTO) {
        StepDTO createdStepDTO = stepService.create(stepDTO);
        return new ResponseEntity<>(createdStepDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StepDTO> getById(@PathVariable Integer id) {
        return stepService.getById(id)
                .map(stepDTO -> new ResponseEntity<>(stepDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<StepDTO>> getAll() {
        Iterable<StepDTO> addresses = stepService.getAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
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
        stepService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}