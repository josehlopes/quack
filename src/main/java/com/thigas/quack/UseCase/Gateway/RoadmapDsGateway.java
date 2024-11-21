package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;

import java.util.Optional;

public interface RoadmapDsGateway {
    void save(RoadmapRequestModel roadmap);

    Optional<RoadmapRequestModel> findById(int id);

    Iterable<RoadmapRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}