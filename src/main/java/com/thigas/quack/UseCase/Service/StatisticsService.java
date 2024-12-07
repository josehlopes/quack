package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Implementation.CommonStatistics;
import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Factory.Interface.StatisticsFactory;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.StatisticsMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

@RequiredArgsConstructor
public class StatisticsService {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);

    private final StatisticsDsGateway statisticsGateway;
    private final StatisticsMapper statisticsMapper;
    private final UserDsGateway userDsGateway;
    private final StatisticsFactory statisticsFactory;


    public void create(Integer userId) {
        Statistics statistics = statisticsFactory.create(userId);
        saveStatistics(statistics);
    }

    public void saveStatistics(Statistics statistics) {
        StatisticsRequestModel statisticsRequestModel = statisticsMapper.toDsModel(statistics);
        statisticsGateway.saveStatistics(statisticsRequestModel);
    }

    public void updateStatistics(StatisticsRequestModel statistics) {
        statisticsGateway.updateStatistics(statistics);
    }

    public Optional<StatisticsRequestModel> getByUserId(Integer id) {
        return statisticsGateway.getByUserId(id);
    }

    public void addExperience(Integer userId, Double experience) {
        StatisticsRequestModel existingStatistic = getExistingStatistic(userId);
        CommonStatistics statistics = statisticsMapper.toEntity(existingStatistic);
        updateExperience(statistics, experience);
        saveUpdatedStatistics(statistics);
    }

    public void addRoadmapCompleteCount(Integer userId) {
        StatisticsRequestModel existingStatistic = getExistingStatistic(userId);
        CommonStatistics statistics = statisticsMapper.toEntity(existingStatistic);
        updateRoadmapCompleteCount(statistics);
        saveUpdatedStatistics(statistics);

    }

    private StatisticsRequestModel getExistingStatistic(Integer userId) {
        return getByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
    }

    private void updateExperience(CommonStatistics statistics, Double experience) {
        statistics.addExperience(experience);
    }

    private void updateRoadmapCompleteCount(CommonStatistics statistics) {
        statistics.updateRoadmapsCompletedCount();
    }

    private void saveUpdatedStatistics(CommonStatistics statistics) {
        StatisticsRequestModel newStatistics = statisticsMapper.toDsModel(statistics);
        updateStatistics(newStatistics);
    }
}