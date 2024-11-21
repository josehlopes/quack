package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserTaskRequestModel;

import java.util.Optional;

public interface UserTaskDsGateway {
    void save(UserTaskRequestModel userTask);

    Optional<UserTaskRequestModel> findById(int id);

    Iterable<UserTaskRequestModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}