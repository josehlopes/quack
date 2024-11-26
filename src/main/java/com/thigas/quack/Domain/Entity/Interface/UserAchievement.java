package com.thigas.quack.Domain.Entity.Interface;

import java.time.OffsetDateTime;

public interface UserAchievement {

    int getId();

    Integer getUserId();

    Integer getAchievementId();

    String getDescription();

    OffsetDateTime getObtainedOn();

    Boolean getisActive();

}
