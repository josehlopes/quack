package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Implementation.CommonStatistics;
import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Factory.Interface.StatisticsFactory;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Mapper.StatisticsMapper;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@AllArgsConstructor
public class StatisticsService {
    
    private static final Logger logger = LoggerFactory.getLogger(StatisticsService.class);
    
    private final StatisticsDsGateway statisticsGateway;
    private final StatisticsMapper statisticsMapper;
    private final UserDsGateway userDsGateway;
    private final StatisticsFactory statisticsFactory;
    
    public void create(Integer userId) {
        try {
            Statistics statistics = statisticsFactory.create(userId);
            saveStatistics(statistics);
        } catch (Exception e) {
            logger.error("Error creating statistics for user ID: {}", userId, e);
            throw new RuntimeException("Error creating statistics");
        }
    }
    
    public void saveStatistics(Statistics statistics) {
        try {
            StatisticsRequestModel statisticsRequestModel = statisticsMapper.toDsModel(statistics);
            statisticsGateway.saveStatistics(statisticsRequestModel);
        } catch (Exception e) {
            logger.error("Error saving statistics", e);
            throw new RuntimeException("Error saving statistics");
        }
    }
    
    public void updateStatistics(StatisticsRequestModel statistics) {
        try {
            statisticsGateway.updateStatistics(statistics);
        } catch (Exception e) {
            logger.error("Error updating statistics", e);
            throw new RuntimeException("Error updating statistics");
        }
    }
    
    public Optional<StatisticsRequestModel> getByUserId(Integer id) {
        try {
            return statisticsGateway.getByUserId(id);
        } catch (Exception e) {
            logger.error("Error getting statistics by user ID: {}", id, e);
            throw new RuntimeException("Error getting statistics");
        }
    }
    
    public void addExperience(Integer userId, Double experience) {
        try {
            StatisticsRequestModel existingStatistic = getExistingStatistic(userId);
            CommonStatistics statistics = statisticsMapper.toEntity(existingStatistic);
            updateExperience(statistics, experience);
            saveUpdatedStatistics(statistics);
        } catch (Exception e) {
            logger.error("Error adding experience for user ID: {}", userId, e);
            throw new RuntimeException("Error adding experience");
        }
    }
    
    public void addRoadmapCompleteCount(Integer userId) {
        try {
            StatisticsRequestModel existingStatistic = getExistingStatistic(userId);
            CommonStatistics statistics = statisticsMapper.toEntity(existingStatistic);
            updateRoadmapCompleteCount(statistics);
            saveUpdatedStatistics(statistics);
        } catch (Exception e) {
            logger.error("Error adding roadmap complete count for user ID: {}", userId, e);
            throw new RuntimeException("Error adding roadmap complete count");
        }
    }
    
    private StatisticsRequestModel getExistingStatistic(Integer userId) {
        try {
            return getByUserId(userId)
                    .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        } catch (EntityNotFoundException e) {
            logger.error("Statistics not found for user ID: {}", userId, e);
            throw e;
        }
    }
    
    private void updateExperience(CommonStatistics statistics, Double experience) {
        statistics.addExperience(experience);
    }
    
    private void updateRoadmapCompleteCount(CommonStatistics statistics) {
        statistics.updateRoadmapsCompletedCount();
    }
    
    private void saveUpdatedStatistics(CommonStatistics statistics) {
        try {
            StatisticsRequestModel newStatistics = statisticsMapper.toDsModel(statistics);
            updateStatistics(newStatistics);
        } catch (Exception e) {
            logger.error("Error saving updated statistics", e);
            throw new RuntimeException("Error saving updated statistics");
        }
    }
}