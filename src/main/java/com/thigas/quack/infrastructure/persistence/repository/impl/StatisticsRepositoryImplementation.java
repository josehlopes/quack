package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStatisticsModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StatisticsRepositoryImplementation implements IStatisticsRepository {

    private final StatisticsMapper statisticsMapper = StatisticsMapper.INSTANCE;
    @Autowired
    private IStatisticsModelRepository statisticsModelRepository;

    @Override
    public StatisticsEntity save(StatisticsEntity statistics) {
        StatisticsModel statisticsModel = statisticsMapper.EntityToModel(statistics);
        StatisticsModel savedStatisticsModel = statisticsModelRepository.save(statisticsModel);
        return statisticsMapper.ModelToEntity(savedStatisticsModel);
    }

    @Override
    public Optional<StatisticsEntity> findById(int id) {
        return statisticsModelRepository.findById(id).map(statisticsMapper::ModelToEntity);
    }

    @Override
    public Iterable<StatisticsEntity> findAll() {
        return statisticsModelRepository.findAll().stream()
                .map(statisticsMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        statisticsModelRepository.deleteById(id);
    }
}