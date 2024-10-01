package com.thigas.quack.domain.repository;

import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

import java.util.Optional;

public interface IRoadmapRepository {

    RoadmapModel save(RoadmapModel roadmap);

    Optional<RoadmapModel> findById(int id);

    Iterable<RoadmapModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}