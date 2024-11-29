package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;

import java.util.Optional;

public interface RoadmapDsGateway {
    Optional<RoadmapRequestModel> findById(Integer id);

    Iterable<RoadmapRequestModel> findAll();

    Boolean existsById(Integer id);
}