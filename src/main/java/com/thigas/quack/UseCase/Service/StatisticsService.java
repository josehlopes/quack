package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Implementation.CommonStatistics;
import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Factory.Interface.StatisticsFactory;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.StatisticsMapper;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsDsGateway statisticsGateway;
    private final StatisticsMapper statisticsMapper;
    private final UserDsGateway userRepository;
    private final StatisticsFactory statisticsFactory;


    public void create(Integer userId) {
        Statistics statistics = statisticsFactory.create(userId);
        saveStatistics(statistics);
    }

    public void saveStatistics(Statistics statistics) {
        StatisticsRequestModel statisticsRequestModel = statisticsMapper.toDsModel(statistics);
        statisticsGateway.save(statisticsRequestModel);
    }

    public void updateStatistics(Statistics statistics) {
        statisticsGateway.update(statisticsMapper.toDsModel(statistics));
    }

    public Optional<StatisticsRequestModel> getByUserId(Integer id) {
        return statisticsGateway.getByUserId(id);
    }

    public void addExperience(Integer userId, Double experience) {
        StatisticsRequestModel existingStatistic = getByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));

        Statistics toSave = statisticsMapper.toEntity(existingStatistic);
        toSave.addExperience(experience);
        saveStatistics(toSave);
    }


}