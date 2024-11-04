package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Model.StatisticsDataMapper;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class StatisticsDsGatewayImplementation implements StatisticsDsGateway {

    @Autowired
    private JpaStatisticsRepository statisticsModelRepository;

    @Override
    public StatisticsDataMapper save(StatisticsDataMapper statisticsDataMapper) {
        return statisticsModelRepository.save(statisticsDataMapper);
    }

    @Override
    public Optional<StatisticsDataMapper> findById(int id) {
        return statisticsModelRepository.findById(id);
    }

    @Override
    public Iterable<StatisticsDataMapper> findAll() {
        return statisticsModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        statisticsModelRepository.deleteById(id);
    }

    @Override
    public Optional<StatisticsDataMapper> findByUserId(int userId) {
        return statisticsModelRepository.findByUserId(userId);
    }
}