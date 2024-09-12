package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.RoadmapUserEntity;

public interface IRoadmapUserRepository {

    RoadmapUserEntity save(RoadmapUserEntity roadmapUser);

    Optional<RoadmapUserEntity> findById(Long id);

    Iterable<RoadmapUserEntity> findAll();

    void deleteById(Long id);
}
