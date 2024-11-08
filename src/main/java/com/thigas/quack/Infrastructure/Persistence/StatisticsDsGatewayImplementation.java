package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.StatisticsDataMapper;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaStatisticsRepository;
import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StatisticsDsGatewayImplementation implements StatisticsDsGateway {

    final JpaStatisticsRepository repository;
    private final MapStructMapper mapper;

    public StatisticsDsGatewayImplementation(JpaStatisticsRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(StatisticsDtoRequestModel statisticsRequest) {
        StatisticsDataMapper toSaveStatistics = mapper.mapStatisticsDtoRequestToDataMapper(statisticsRequest);
        repository.save(toSaveStatistics);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findById(int id) {
        Optional<StatisticsDataMapper> statistics = repository.findById(id);
        return statistics.map(mapper::mapStatisticsDataMapperToDtoRequest);
    }

    @Override
    public Iterable<StatisticsDtoRequestModel> findAll() {
        Iterable<StatisticsDataMapper> statistics = repository.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .map(mapper::mapStatisticsDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<StatisticsDtoRequestModel> findByUserId(int userId) {
        Optional<StatisticsDataMapper> statistics = repository.findByUserId(userId);
        return statistics.map(mapper::mapStatisticsDataMapperToDtoRequest);
    }
}