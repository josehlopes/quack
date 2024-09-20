package com.thigas.quack.adapter.controller;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.application.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @PostMapping
    public ResponseEntity<StatisticsDTO> create(@RequestBody StatisticsDTO statisticsDTO) {
        StatisticsDTO createdStatistics = statisticsService.create(statisticsDTO);
        return new ResponseEntity<>(createdStatistics, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatisticsDTO> getById(@PathVariable Integer id) {
        return statisticsService.getById(id).map(statisticsDTO -> new ResponseEntity<>(statisticsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<Iterable<StatisticsDTO>> getAll() {
        Iterable<StatisticsDTO> statistics = statisticsService.getAll();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody StatisticsDTO statisticsDTO) {
        if (id.equals(statisticsDTO.getId())) {
            statisticsService.update(statisticsDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        statisticsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
