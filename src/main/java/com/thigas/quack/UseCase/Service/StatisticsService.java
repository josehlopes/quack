package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class StatisticsService {

    private final StatisticsDsGateway statisticsGateway;

    private final UserDsGateway userRepository;

    public void create(StatisticsRequestModel statisticsRequest) {
        statisticsGateway.save(statisticsRequest);
    }

    public Optional<StatisticsRequestModel> getById(int id) {
        return statisticsGateway.findById(id);
    }

    public Iterable<StatisticsRequestModel> getAll() {
        Iterable<StatisticsRequestModel> statistics = statisticsGateway.findAll();
        return StreamSupport.stream(statistics.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(StatisticsRequestModel statisticsRequest) {
        StatisticsRequestModel existingStatistics = statisticsGateway.findById(statisticsRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found"));
        StatisticsRequestModel updatedStatistics = new StatisticsRequestModel(
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
        UserDsRequestModel user = userRepository.getById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        StatisticsRequestModel statistics = new StatisticsRequestModel(
                null, user.id(), 0, 0, 0, 0.0, 0.0, 0, 0
        );
        statisticsGateway.save(statistics);
    }

    public void incrementRoadmapsCompleted(int userId) {
        StatisticsRequestModel statistics = statisticsGateway.findByUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Statistics not found for user ID: " + userId));
        statistics = new StatisticsRequestModel(
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