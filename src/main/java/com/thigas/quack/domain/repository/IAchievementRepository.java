package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.AchievementEntity;

import java.util.Optional;

public interface IAchievementRepository {

    AchievementEntity save(AchievementEntity achievement);

    Optional<AchievementEntity> findById(int id);

    Iterable<AchievementEntity> findAll();

    void deleteById(int id);
}