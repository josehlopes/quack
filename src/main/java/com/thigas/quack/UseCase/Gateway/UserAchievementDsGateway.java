package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Infrastructure.Entity.UserAchievementDataMapper;

import java.util.Optional;

public interface UserAchievementDsGateway {
    UserAchievementDataMapper save(UserAchievementDataMapper userAchievement);
    Optional<UserAchievementDataMapper> findById(int id);
    boolean existsById(int id);
    Iterable<UserAchievementDataMapper> findAll();
    void deleteById(int id);
}
