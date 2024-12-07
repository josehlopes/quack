package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StatisticsRequestModel;
import com.thigas.quack.UseCase.Model.Response.StatisticsInfoResponseModel;

import java.util.Optional;

public interface StatisticsDsGateway {
    void save(StatisticsRequestModel statistics);
    Optional<StatisticsRequestModel> getById(Integer id);
    Iterable<StatisticsRequestModel> getAll();
    Optional<StatisticsRequestModel> getByUserId(Integer userId);
    void update(StatisticsRequestModel statistics);

}