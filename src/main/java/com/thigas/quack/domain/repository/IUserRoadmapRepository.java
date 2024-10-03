package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;

import java.util.Optional;

public interface IUserRoadmapRepository {

    UserRoadmapModel save(UserRoadmapModel roadmapUser);

    Optional<UserRoadmapModel> findById(int id);

    Iterable<UserRoadmapModel> findAll();

    void deleteById(int id);
}
