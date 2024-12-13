package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserStepDsGateway {
    void save(UserStepRequestModel userStep);

    void update(UserStepRequestModel userStep);

    Optional<UserStepRequestModel> getById(Integer id);

    Iterable<UserStepRequestModel> getAll();

    Boolean existsById(Integer id);

    void deleteById(Integer id);

    List<UserStepRequestModel> getStepsByUserId(Integer userId);
}
