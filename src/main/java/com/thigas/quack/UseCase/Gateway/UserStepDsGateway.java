package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Infrastructure.Entity.UserStepDataMapper;

import java.util.Optional;

public interface UserStepDsGateway {
    void save(UserStepDataMapper userStep);
    Optional<UserStepDataMapper> findById(int id);
    Iterable<UserStepDataMapper> findAll();
    boolean existsById(int id);
    void deleteById(int id);
}
