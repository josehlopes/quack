package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.AchievementEntity;

public interface IAchievementRepository {

    AchievementEntity save(AchievementEntity achievement);

    Optional<AchievementEntity> findById(int id);

    Iterable<AchievementEntity> findAll();

    void deleteById(int id);
}