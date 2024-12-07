package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;

import java.util.Optional;

public interface StatisticsDsGateway {
    void saveStatistics(StatisticsRequestModel request);
    Optional<StatisticsRequestModel> getStatisticsById(Integer id);
    Optional<StatisticsRequestModel> getByUserId(Integer userId);
    void updateStatistics(StatisticsRequestModel request);

}