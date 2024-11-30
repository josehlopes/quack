package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StepRequestModel;

import java.util.Optional;

public interface StepDsGateway {
    Boolean existsById(Integer id);

    Optional<StepRequestModel> getById(Integer id);

    Iterable<StepRequestModel> getAll();

}
