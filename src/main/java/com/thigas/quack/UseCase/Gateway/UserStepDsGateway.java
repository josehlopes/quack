package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;

import java.util.Optional;

public interface UserStepDsGateway {
    void save(UserStepRequestModel userStep);

    Optional<UserStepRequestModel> findById(int id);

    Iterable<UserStepRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
