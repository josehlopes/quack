package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.UserTaskDataMapper;

import java.util.Optional;

public interface UserTaskDsGateway {
    void save(UserTaskDataMapper userTask);
    Optional<UserTaskDataMapper> findById(int id);
    Iterable<UserTaskDataMapper> findAll();
    Boolean existsById(int id);
    void deleteById(int id);
}