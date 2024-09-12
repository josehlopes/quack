package com.thigas.quack.domain.repository;

import java.util.Optional;
import com.thigas.quack.domain.entity.StatisticsEntity;

public interface IStatisticsRepository {

    StatisticsEntity save(StatisticsEntity Statistics);

    Optional<StatisticsEntity> findById(int id);

    Iterable<StatisticsEntity> findAll();

    void deleteById(int id);
}