package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
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

    @Autowired
    private CycleAvoidingMappingContext context;

    public StatisticsDTO create(StatisticsDTO statisticsDTO) {
        StatisticsModel statisticsModel = statisticsMapper.dtoToModel(statisticsDTO, new CycleAvoidingMappingContext());
        StatisticsModel savedStatistics = statisticsRepository.save(statisticsModel);
        return statisticsMapper.modelToDto(savedStatistics, context);
    }

    public Optional<StatisticsDTO> getById(int id) {
        Optional<StatisticsModel> statisticsOptional = statisticsRepository.findById(id);
        return statisticsOptional.map(statistics -> statisticsMapper.modelToDto(statistics, context));
    }

    public Iterable<StatisticsDTO> getAll() {
        Iterable<StatisticsModel> statistics = statisticsRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(statistics.spliterator(), false).map(statistic -> statisticsMapper.modelToDto(statistic, context)).collect(Collectors.toList());

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