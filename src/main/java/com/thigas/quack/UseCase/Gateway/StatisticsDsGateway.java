package com.thigas.quack.UseCase.Gateway;



import com.thigas.quack.UseCase.Model.Request.StatisticsDtoRequestModel;

import java.util.Optional;

public interface StatisticsDsGateway {
    void save(StatisticsDtoRequestModel statistics);
    Optional<StatisticsDtoRequestModel> findById(int id);
    Iterable<StatisticsDtoRequestModel> findAll();
    void deleteById(int id);
    Optional<StatisticsDtoRequestModel> findByUserId(int userId);
    void incrementRoadmapsCompleted(int userId);
    void createInitialStatisticsForUser(int userId);
}