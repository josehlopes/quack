package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;

import java.util.Optional;

public interface RoadmapDsGateway {
    Optional<RoadmapRequestModel> getRoadmapById(Integer id);
    Iterable<RoadmapRequestModel> getAllRoadmaps();
    Boolean existsById(Integer id);
    Iterable<RoadmapRequestModel> getAllRoadmapByCategory(String category);
}