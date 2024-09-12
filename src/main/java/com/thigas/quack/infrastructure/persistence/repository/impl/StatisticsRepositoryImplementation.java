package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStatisticsModelRepository;

@Repository
public class StatisticsRepositoryImplementation implements IStatisticsRepository {

    @Autowired
    private IStatisticsModelRepository statisticsModelRepository;
    private final StatisticsMapper statisticsMapper = StatisticsMapper.INSTANCE;

    @Override
    public StatisticsEntity save(StatisticsEntity statistics) {
        StatisticsModel statisticsModel = statisticsMapper.toStatisticsModel(statistics);
        StatisticsModel savedStatisticsModel = statisticsModelRepository.save(statisticsModel);
        return statisticsMapper.toStatistics(savedStatisticsModel);
    }

    @Override
    public Optional<StatisticsEntity> findById(int id) {
        return statisticsModelRepository.findById(id).map(statisticsMapper::toStatistics);
    }

    @Override
    public Iterable<StatisticsEntity> findAll() {
        return statisticsModelRepository.findAll().stream()
                .map(statisticsMapper::toStatistics)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        statisticsModelRepository.deleteById(id);
    }
}