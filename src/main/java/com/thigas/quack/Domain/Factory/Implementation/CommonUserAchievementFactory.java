package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserAchievement;
import com.thigas.quack.Domain.Entity.Interface.UserAchievement;
import com.thigas.quack.Domain.Factory.Interface.UserAchievementFactory;

import java.time.OffsetDateTime;

public class CommonUserAchievementFactory implements UserAchievementFactory {
    @Override
    public UserAchievement create(Integer userId, Integer achievementId, String description) {
        OffsetDateTime obtainedOn = OffsetDateTime.now();
        Boolean isActive = true;
        return new CommonUserAchievement(null, userId, achievementId, description, obtainedOn, isActive);
    }
}
