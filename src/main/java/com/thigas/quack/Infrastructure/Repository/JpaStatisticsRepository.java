package com.thigas.quack.Infrastructure.Repository;

import com.thigas.quack.Infrastructure.Model.StatisticsDataMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaStatisticsRepository extends JpaRepository<StatisticsDataMapper, Integer> {
    Optional<StatisticsDataMapper> findByUserId(int userId);
}