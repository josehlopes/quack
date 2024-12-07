package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Adapter.Repository.JpaStatisticsRepository;
import com.thigas.quack.Adapter.Repository.StatisticsRepository;
import com.thigas.quack.Adapter.Repository.UserRepository;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Mapper.StatisticsMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Response.StatisticsInfoResponseModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class StatisticsDsGatewayImplementation implements StatisticsDsGateway {

    private final StatisticsRepository repository;
    private final UserRepository userRepository;
    private final StatisticsMapper mapper;

    @Override
    public void save(StatisticsRequestModel statisticsRequest) {
        StatisticsDataMapper toSaveStatistics = mapper.toDataMapper(statisticsRequest);
        repository.save(toSaveStatistics);
    }
    
    @Override
    public void update(StatisticsRequestModel statisticsRequest) {
        StatisticsDataMapper toUpdateStatistics = mapper.toDataMapper(statisticsRequest);
        repository.update(toUpdateStatistics);
    }

    @Override
    public Optional<StatisticsRequestModel> getById(Integer id) {
        Optional<StatisticsDataMapper> statistics = repository.getById(id);
        return statistics.map(mapper::toDsModel);
    }

    @Override
    public Iterable<StatisticsRequestModel> getAll() {
        Iterable<StatisticsDataMapper> users = repository.getAll();
        return StreamSupport.stream(users.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }


    //TODO: MÉTODO ESTÁ INCORRETO, DEVE SER ALTERADO
    @Override
    public Optional<StatisticsRequestModel> getByUserId(Integer userId) {
        Optional<StatisticsDataMapper> statistics = repository.getUserStatistics(userId);
        return statistics.map(mapper::toDsModel);
    }
}