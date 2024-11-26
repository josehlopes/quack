package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserAchievement;

public interface UserAchievementFactory {
    UserAchievement create(Integer userId, Integer achievementId, String description);
}
