package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementUnlockRequestModel;

import java.util.Optional;

public interface UserAchievementDsGateway {

    void save(UserAchievementRequestModel dataSourceModel);

    void unlockUserAchievement(UserAchievementUnlockRequestModel dataSourceModel);

    Optional<UserAchievementRequestModel> getUserAchievementById(Integer id);

    Boolean findByUserIdAndAchievementId(Integer userId, Integer achievementId);

    Iterable<AchievementRequestModel> getAllUserAchievements(Integer userId);

    void lockUserAchievement(Integer userAchievementId);

    void deleteUserAchievementById(Integer id);
}
