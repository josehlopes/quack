package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StepDtoRequestModel;

import java.util.Optional;

public interface StepDsGateway {
    void save(StepDtoRequestModel step);

    Boolean existsById(int id);

    Optional<StepDtoRequestModel> findById(int id);

    Iterable<StepDtoRequestModel> findAll();

    void deleteById(int id);
}
