package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Entity.StatisticsDataMapper;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaStatisticsRepository;
import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;


public class StatisticsDsGatewayImplementation implements StatisticsDsGateway {

    final JpaStatisticsRepository repository;


    @Autowired
    private ObjectMapperService objectMapperService;

    public StatisticsDsGatewayImplementation(JpaStatisticsRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(StatisticsDtoRequestModel statisticsRequest) {
        StatisticsDataMapper statisticsToSave = new StatisticsDataMapper(
                statisticsRequest.getId(),
                objectMapperService.toModel(statisticsRequest.getUser()),
                statisticsRequest.getStreakDays(),
                statisticsRequest.getBestStreak(),
                statisticsRequest.getUserLevel(),
                statisticsRequest.getUserExperience(),
                statisticsRequest.getChallengesCompletedCount(),
                statisticsRequest.getRoadmapsCompletedCount(),
                statisticsRequest.getPoints()
        );
        repository.save(statisticsToSave);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findById(int id) {
        return repository.findById(id).map(objectMapperService::toDto);
    }

    @Override
    public Iterable<StatisticsDtoRequestModel> findAll() {
        return repository.findAll().stream().map(objectMapperService::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findByUserId(int userId) {
        return repository.findByUserId(userId).map(objectMapperService::toDto);
    }
}