package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;

import java.util.Optional;

public interface StatisticsDsGateway {
    void save(StatisticsRequestModel statistics);

    Optional<StatisticsRequestModel> findById(int id);

    Iterable<StatisticsRequestModel> findAll();

    void deleteById(int id);

    Optional<StatisticsRequestModel> findByUserId(int userId);

    void incrementRoadmapsCompleted(int userId);

//    void createInitialStatisticsForUser(int userId);
}