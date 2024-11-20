package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.UseCase.Model.Request.User.UserStepDtoRequestModel;

import java.util.Optional;

public interface UserStepDsGateway {
    void save(UserStepDtoRequestModel userStep);

    Optional<UserStepDtoRequestModel> findById(int id);

    Iterable<UserStepDtoRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
