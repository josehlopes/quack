package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.RoadmapUser;

public interface IRoadmapUserRepository {

    RoadmapUser save(RoadmapUser roadmapUser);

    Optional<RoadmapUser> findById(Long id);

    Iterable<RoadmapUser> findAll();

    void deleteById(Long id);
}
