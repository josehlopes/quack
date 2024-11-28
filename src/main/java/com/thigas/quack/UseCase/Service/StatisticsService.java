package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Factory.Interface.StatisticsFactory;
import com.thigas.quack.Domain.Factory.Interface.UserFactory;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.StatisticsMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsDsGateway statisticsGateway;
    private final StatisticsMapper statisticsMapper;
    private final UserDsGateway userRepository;
    private final StatisticsFactory statisticsFactory;


    void create(Integer userId) {
        Statistics statistics = statisticsFactory.create(userId);
        saveStatistics(statistics);
    }

    void saveStatistics(Statistics statistics) {
        StatisticsRequestModel statisticsRequestModel = statisticsMapper.toDsModel(statistics);
        statisticsGateway.save(statisticsRequestModel);
    }
}