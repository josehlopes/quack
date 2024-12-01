package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;

import java.util.Optional;

public interface RoadmapDsGateway {
    Optional<RoadmapRequestModel> getById(Integer id);
    Iterable<RoadmapRequestModel> getAll();
    Boolean existsById(Integer id);
    Iterable<RoadmapRequestModel> getByCategory(String category);
}