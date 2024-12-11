package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserRoadmap;
import com.thigas.quack.Domain.Entity.Interface.UserRoadmap;
import com.thigas.quack.Domain.Factory.Interface.UserRoadmapFactory;
import com.thigas.quack.Domain.Utils.Status;

import java.time.LocalDate;

public class CommonUserRoadmapFactory implements UserRoadmapFactory {
    @Override
    public UserRoadmap create(Integer userId, Integer roadmapId) {
        LocalDate startedIn = LocalDate.now();
        return new CommonUserRoadmap(null, userId, roadmapId, 0.0, startedIn, null, Status.ACTIVE);
    }
}
