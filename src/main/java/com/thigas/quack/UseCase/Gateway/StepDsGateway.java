package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StepRequestModel;

import java.util.Optional;

public interface StepDsGateway {
    void save(StepRequestModel step);

    Boolean existsById(int id);

    Optional<StepRequestModel> findById(int id);

    Iterable<StepRequestModel> findAll();

    void deleteById(int id);
}
