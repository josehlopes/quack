package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.User.UserRoadmapDtoRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserRoadmapDsGateway {
    void save(UserRoadmapDtoRequestModel roadmapUser);

    Optional<UserRoadmapDtoRequestModel> findById(int id);

    List<UserRoadmapDtoRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
