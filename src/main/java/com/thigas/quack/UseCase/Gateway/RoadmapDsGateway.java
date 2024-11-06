package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;

import java.util.Optional;

public interface RoadmapDsGateway {
    void save(RoadmapDtoRequestModel roadmap);
    Optional<RoadmapDtoRequestModel> findById(int id);
    Iterable<RoadmapDtoRequestModel> findAll();
    boolean existsById(int id);
    void deleteById(int id);
}