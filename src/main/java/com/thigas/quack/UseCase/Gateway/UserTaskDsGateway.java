package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.User.UserTaskDtoRequestModel;

import java.util.Optional;

public interface UserTaskDsGateway {
    void save(UserTaskDtoRequestModel userTask);

    Optional<UserTaskDtoRequestModel> findById(int id);

    Iterable<UserTaskDtoRequestModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}