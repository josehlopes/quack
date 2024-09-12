package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.RoadmapEntity;

public interface IRoadmapRepository {

    RoadmapEntity save(RoadmapEntity roadmap);

    Optional<RoadmapEntity> findById(Long id);

    Iterable<RoadmapEntity> findAll();

    void deleteById(Long id);
}