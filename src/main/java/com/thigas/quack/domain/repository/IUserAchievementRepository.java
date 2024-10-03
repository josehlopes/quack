package com.thigas.quack.domain.repository;

import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;

import java.util.Optional;

public interface IUserAchievementRepository {

    UserAchievementModel save(UserAchievementModel roadmapUser);
    Optional<UserAchievementModel> findById(int id);
    Iterable<UserAchievementModel> findAll();
    void deleteById(int id);

}
