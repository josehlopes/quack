package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.UserAchievementDsRequestModel;

import java.util.Optional;

public interface UserAchievementDsGateway {
    Optional<UserAchievementDsRequestModel> findUserAchievementById(Integer id);

    Boolean existsUserAchievementById(Integer id);

    Boolean existsUserAchievementByUserIdAndAchievementId(Integer userId, Integer achievementId);

    void unlockUserAchievement(Integer userId, Integer achievementId);

    void lockUserAchievement(Integer userAchievementId);

    Iterable<UserAchievementDsRequestModel> findAllAchievementsByUser();

    void deleteUserAchievementById(Integer id);
}