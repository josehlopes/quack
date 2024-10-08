package com.thigas.quack.infrastructure.persistence.repository.jpa;

import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatisticsModelRepository extends JpaRepository<StatisticsModel, Integer> {

}