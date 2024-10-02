package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {

    @Autowired
    private IStatisticsRepository statisticsRepository;

    @Autowired
    private StatisticsMapper statisticsMapper;

    public StatisticsDTO create(StatisticsDTO statisticsDTO) {
        StatisticsModel statisticsModel = statisticsMapper.dtoToModel(statisticsDTO);
        StatisticsModel savedStatistics = statisticsRepository.save(statisticsModel);
        return statisticsMapper.modelToDto(savedStatistics);
    }

    public Optional<StatisticsDTO> getById(int id) {
        Optional<StatisticsModel> statistics = statisticsRepository.findById(id);
        return statistics.map(statisticsMapper::modelToDto);
    }

    public Iterable<StatisticsDTO> getAll() {
        Iterable<StatisticsModel> statistics = statisticsRepository.findAll();
        return StreamSupport.stream(statistics.spliterator(), false).map(statisticsMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDTO statisticsDTO) {
        StatisticsModel existingUser = statisticsRepository.findById(statisticsDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        statisticsRepository.save(existingUser);
    }

    public void delete(int id) {
        statisticsRepository.deleteById(id);
    }
}