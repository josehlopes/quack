package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.UserRoadmapEntity;

public interface IUserRoadmapRepository {

    UserRoadmapEntity save(UserRoadmapEntity roadmapUser);

    Optional<UserRoadmapEntity> findById(int id);

    Iterable<UserRoadmapEntity> findAll();

    void deleteById(int id);
}
