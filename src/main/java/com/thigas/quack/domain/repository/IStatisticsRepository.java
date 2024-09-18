package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.StatisticsEntity;

import java.util.Optional;

public interface IStatisticsRepository {

    StatisticsEntity save(StatisticsEntity Statistics);

    Optional<StatisticsEntity> findById(int id);

    Iterable<StatisticsEntity> findAll();

    void deleteById(int id);
}