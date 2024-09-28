package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.RoadmapEntity;

import java.util.Optional;

public interface IRoadmapRepository {

    RoadmapEntity save(RoadmapEntity roadmap);

    Optional<RoadmapEntity> findById(int id);

    Iterable<RoadmapEntity> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}