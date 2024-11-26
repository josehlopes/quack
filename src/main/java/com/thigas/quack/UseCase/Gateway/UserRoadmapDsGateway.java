package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserRoadmapDsGateway {
    void save(UserRoadmapRequestModel roadmapUser);

    Optional<UserRoadmapRequestModel> findById(int id);

    List<UserRoadmapRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
