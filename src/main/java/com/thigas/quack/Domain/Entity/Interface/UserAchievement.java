package com.thigas.quack.Domain.Entity.Interface;

import com.thigas.quack.Domain.Utils.Status;

import java.time.OffsetDateTime;

public interface UserAchievement {

    int getId();

    User getUser();

    Achievement getAchievement();

    String getImagePath();

    OffsetDateTime getObtainedOn();

    Status getStatus();

}
