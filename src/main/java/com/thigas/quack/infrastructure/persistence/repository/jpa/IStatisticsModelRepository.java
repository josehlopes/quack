package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStatisticsModelRepository extends JpaRepository<StatisticsModel, Integer> {
    Optional<StatisticsModel> findByUserId(int userId);
}