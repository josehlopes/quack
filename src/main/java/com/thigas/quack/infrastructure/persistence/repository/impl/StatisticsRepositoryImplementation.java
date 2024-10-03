package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.adapter.mapper.StatisticsMapper;
import com.thigas.quack.domain.repository.IStatisticsRepository;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IStatisticsModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StatisticsRepositoryImplementation implements IStatisticsRepository {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Autowired
    private IStatisticsModelRepository statisticsModelRepository;

    @Override
    @Transactional
    public StatisticsModel save(StatisticsModel statisticsModel) {
        return statisticsModelRepository.save(statisticsModel);
    }

    @Override
    @Transactional
    public Optional<StatisticsModel> findById(int id) {
        return statisticsModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<StatisticsModel> findAll() {
        return statisticsModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        statisticsModelRepository.deleteById(id);
    }
}