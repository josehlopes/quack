package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.UserRoadmapEntity;

import java.util.Optional;

public interface IUserRoadmapRepository {

    UserRoadmapEntity save(UserRoadmapEntity roadmapUser);

    Optional<UserRoadmapEntity> findById(int id);

    Iterable<UserRoadmapEntity> findAll();

    void deleteById(int id);
}
