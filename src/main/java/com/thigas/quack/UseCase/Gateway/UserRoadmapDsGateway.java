package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserRoadmapDsGateway {
    Boolean saveUserRoadmap(UserRoadmapRequestModel dataSourceModel);
    UserRoadmapRequestModel updateUserRoadmap(UserRoadmapRequestModel userRoadmap);
    Optional<UserRoadmapRequestModel> getUserRoadmapById(Integer id);
    UserRoadmapRequestModel updateProgressToComplete(UserRoadmapRequestModel userRoadmap);
    List<RoadmapRequestModel> getAllUserRoadmaps(Integer userId);
}
