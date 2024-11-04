package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.StatisticsDataMapper;

import java.util.Optional;

public interface StatisticsDsGateway {
    StatisticsDataMapper save(StatisticsDataMapper Statistics);
    Optional<StatisticsDataMapper> findById(int id);
    Iterable<StatisticsDataMapper> findAll();
    void deleteById(int id);
    Optional<StatisticsDataMapper> findByUserId(int userId);
}