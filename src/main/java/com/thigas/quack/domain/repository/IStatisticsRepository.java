package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;

import java.util.Optional;

public interface IStatisticsRepository {

    StatisticsModel save(StatisticsModel Statistics);

    Optional<StatisticsModel> findById(int id);

    Iterable<StatisticsModel> findAll();

    void deleteById(int id);

    Optional<StatisticsModel> findByUserId(int userId);
}