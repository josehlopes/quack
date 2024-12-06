package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;

import java.util.Optional;

public interface UserRoadmapDsGateway {
    Boolean save(UserRoadmapRequestModel dataSourceModel);

    void startRoadmap(UserRoadmapRequestModel dataSourceModel);

    Optional<UserRoadmapRequestModel> getUserRoadmapById(Integer id);

    Boolean findByUserIdAndRoadmapId(Integer userId, Integer achievementId);

    Iterable<RoadmapRequestModel> getAllUserRoadmaps(Integer userId);

    void endRoadmap(Integer userRoadmapId);

    void deleteUserRoadmapById(Integer userRoadmapId);
}
