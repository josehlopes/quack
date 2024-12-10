package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;

import java.util.Optional;

public interface UserStepDsGateway {
    void save(UserStepRequestModel userStep);

    Optional<UserStepRequestModel> findById(Integer id);

    Iterable<UserStepRequestModel> findAll();

    boolean existsById(Integer id);

    void deleteById(Integer id);
}
