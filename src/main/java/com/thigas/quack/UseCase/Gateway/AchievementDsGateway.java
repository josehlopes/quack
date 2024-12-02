package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;

import java.util.Optional;

public interface AchievementDsGateway {

    Optional<AchievementRequestModel> getById(Integer id);

    Iterable<AchievementRequestModel> getAll();

    Boolean existsById(Integer id);

}