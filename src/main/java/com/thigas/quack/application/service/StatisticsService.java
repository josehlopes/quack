package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {

    private final StatisticsMapper statisticsMapper = StatisticsMapper.INSTANCE;
    @Autowired
    private IStatisticsRepository statisticsRepository;

    public StatisticsDTO create(StatisticsDTO statisticsDTO) {
        StatisticsEntity statistics = statisticsMapper.dtoToEntity(statisticsDTO);
        StatisticsEntity toSaveStatistics = statisticsRepository.save(statistics);
        return statisticsMapper.entityToDto(toSaveStatistics);
    }

    public Optional<StatisticsDTO> getById(int id) {
        Optional<StatisticsEntity> statistics = statisticsRepository.findById(id);
        return statistics.map(statisticsMapper::entityToDto);
    }

    public Iterable<StatisticsDTO> getAll() {
        Iterable<StatisticsEntity> statisticss = statisticsRepository.findAll();
        return StreamSupport.stream(statisticss.spliterator(), false).map(statisticsMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDTO statisticsDTO) {
        StatisticsEntity statistics = statisticsMapper.dtoToEntity(statisticsDTO);
        statisticsRepository.save(statistics);
    }

    public void delete(int id) {
        statisticsRepository.deleteById(id);
    }
}