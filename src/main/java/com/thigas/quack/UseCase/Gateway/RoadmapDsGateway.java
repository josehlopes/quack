package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Infrastructure.Entity.RoadmapDataMapper;

import java.util.Optional;

public interface RoadmapDsGateway {
    void save(RoadmapDataMapper roadmap);
    Optional<RoadmapDataMapper> findById(int id);
    Iterable<RoadmapDataMapper> findAll();
    boolean existsById(int id);
    void deleteById(int id);
}