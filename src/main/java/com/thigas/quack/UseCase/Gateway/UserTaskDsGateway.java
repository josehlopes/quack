package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserTaskRequestModel;

import java.util.Optional;

public interface UserTaskDsGateway {
    void save(UserTaskRequestModel userTask);

    Optional<UserTaskRequestModel> findById(Integer id);

    Iterable<UserTaskRequestModel> findAll();

    Boolean existsById(Integer id);

    void deleteById(Integer id);
}