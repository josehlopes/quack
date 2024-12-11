package com.thigas.quack.Domain.Factory.Interface;

import com.thigas.quack.Domain.Entity.Interface.UserRoadmap;

public interface UserRoadmapFactory {
    UserRoadmap create(Integer userId, Integer roadmapId);

}
