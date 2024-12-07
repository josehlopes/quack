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
        statisticsGateway.save(statisticsRequestModel);
    }

    public void updateStatistics(StatisticsRequestModel statistics) {
        statisticsGateway.update(statistics);
    }

    public Optional<StatisticsRequestModel> getByUserId(Integer id) {
        return statisticsGateway.getByUserId(id);
    }

    public void addExperience(Integer userId, Double experience) {
        StatisticsRequestModel existingStatistic = getByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        CommonStatistics statistics = statisticsMapper.toEntity(existingStatistic);
        statistics.addExperience(20.0);
        StatisticsRequestModel newStatistics = statisticsMapper.toDsModel(statistics);
        updateStatistics(newStatistics);
    }

//    public StatisticsRequestModel updateStatisticsDetails(StatisticsRequestModel oldStatistics, StatisticsRequestModel newStatistics) {
//        return new StatisticsRequestModel(
//                oldStatistics.userId(),
//                oldStatistics.streakDays() != null ? oldStatistics.streakDays() : newStatistics.streakDays(),
//                oldStatistics.bestStreak() != null? oldStatistics.bestStreak() : newStatistics.bestStreak(),
//                oldStatistics.level() != null ? oldStatistics.level() : newStatistics.level(),
//                oldStatistics.nextLevel() !=  null ? oldStatistics.nextLevel() : newStatistics.level(),
//                oldStatistics.points() != null ? oldStatistics.points() : newStatistics.points(),
//                oldStatistics.experience() != null ? oldStatistics.experience() : newStatistics.experience(),
//                oldStatistics.experienceToNextLevel() != null ? oldStatistics.experienceToNextLevel() : newStatistics.experienceToNextLevel(),
//                oldStatistics.challengesCompletedCount() != null ? oldStatistics.challengesCompletedCount() : newStatistics.challengesCompletedCount(),
//                oldStatistics.roadmapsCompletedCount() != null ? oldStatistics.roadmapsCompletedCount() : newStatistics.roadmapsCompletedCount(),
//                oldStatistics.achievementsUnlockedCount() != null ? oldStatistics.achievementsUnlockedCount() : newStatistics.achievementsUnlockedCount(),
//                oldStatistics.achievementsLockedCount() != null ? oldStatistics.achievementsLockedCount() : newStatistics.achievementsLockedCount()
//        );
//    }


}