package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsDsGateway statisticsGateway;

    @Autowired
    private UserDsGateway userRepository;

    public void create(StatisticsDtoRequestModel statisticsRequest) {
        statisticsGateway.save(statisticsRequest);
    }

    public Optional<StatisticsDtoRequestModel> getById(int id) {
        return statisticsGateway.findById(id);
    }

    public Iterable<StatisticsDtoRequestModel> getAll() {
        Iterable<StatisticsDtoRequestModel> statistics = statisticsGateway.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(StatisticsDtoRequestModel statisticsRequest) {
        StatisticsDtoRequestModel existingStatistics = statisticsGateway.findById(statisticsRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found"));
        StatisticsDtoRequestModel updatedStatistics = new StatisticsDtoRequestModel(
                statisticsRequest.id(),
                statisticsRequest.userId() != null ? statisticsRequest.userId() : existingStatistics.userId(),
                statisticsRequest.streakDays() != null ? statisticsRequest.streakDays() : existingStatistics.streakDays(),
                statisticsRequest.bestStreak() != null ? statisticsRequest.bestStreak() : existingStatistics.bestStreak(),
                statisticsRequest.userLevel() != null ? statisticsRequest.userLevel() : existingStatistics.userLevel(),
                statisticsRequest.points() != null ? statisticsRequest.points() : existingStatistics.points(),
                statisticsRequest.userExperience() != null ? statisticsRequest.userExperience() : existingStatistics.userExperience(),
                statisticsRequest.challengesCompletedCount() != null ? statisticsRequest.challengesCompletedCount() : existingStatistics.challengesCompletedCount(),
                statisticsRequest.roadmapsCompletedCount() != null ? statisticsRequest.roadmapsCompletedCount() : existingStatistics.roadmapsCompletedCount()
        );
        statisticsGateway.save(updatedStatistics);
    }

    public void createInitialStatisticsForUser(int userId) {
        UserDtoRequestModel user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        StatisticsDtoRequestModel statistics = new StatisticsDtoRequestModel(
                null, user.id(), 0, 0, 0, 0.0, 0.0, 0, 0
        );
        statisticsGateway.save(statistics);
    }

    public void incrementRoadmapsCompleted(int userId) {
        StatisticsDtoRequestModel statistics = statisticsGateway.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statistics = new StatisticsDtoRequestModel(
                statistics.id(), statistics.userId(), statistics.streakDays(), statistics.bestStreak(),
                statistics.userLevel(), statistics.points(), statistics.userExperience(),
                statistics.challengesCompletedCount(), statistics.roadmapsCompletedCount() + 1
        );
        statisticsGateway.save(statistics);
    }

    public void delete(int id) {
        statisticsGateway.deleteById(id);
    }
}