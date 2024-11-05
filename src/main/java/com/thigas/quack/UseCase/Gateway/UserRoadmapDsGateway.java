package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Entity.UserRoadmapDataMapper;

import java.util.List;
import java.util.Optional;

public interface UserRoadmapDsGateway {
    void save(UserRoadmapDataMapper roadmapUser);
    Optional<UserRoadmapDataMapper> findById(int id);
    List<UserRoadmapDataMapper> findAll();
    boolean existsById(int id);
    void deleteById(int id);
}
