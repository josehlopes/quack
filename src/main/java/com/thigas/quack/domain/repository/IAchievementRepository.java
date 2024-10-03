package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

import java.util.Optional;

public interface IAchievementRepository {

    AchievementModel save(AchievementModel achievement);

    Optional<AchievementModel> findById(int id);

    Iterable<AchievementModel> findAll();

    void deleteById(int id);

}