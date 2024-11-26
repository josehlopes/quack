package com.thigas.quack.Adapter.Repository;

import com.thigas.quack.Adapter.Entity.StatisticsDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaStatisticsRepository extends JpaRepository<StatisticsDataMapper, Integer> {
    Optional<StatisticsDataMapper> findByUserId(int userId);
}