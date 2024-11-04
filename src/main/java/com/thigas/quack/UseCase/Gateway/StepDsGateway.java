package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.StepDataMapper;

import java.util.Optional;

public interface StepDsGateway {
    void save(StepDataMapper step);
    Boolean existsById(int id);
    Optional<StepDataMapper> findById(int id);
    Iterable<StepDataMapper> findAll();
    void deleteById(int id);
}
