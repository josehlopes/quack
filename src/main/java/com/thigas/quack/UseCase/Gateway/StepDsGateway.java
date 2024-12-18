package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.StepRequestModel;

import java.util.List;
import java.util.Optional;

public interface StepDsGateway {
    Boolean existsById(Integer id);

    Optional<StepRequestModel> getStepById(Integer id);

    Iterable<StepRequestModel> getAllSteps();

    List<StepRequestModel> getStepsByRoadmapId(Integer roadmapId);

}
