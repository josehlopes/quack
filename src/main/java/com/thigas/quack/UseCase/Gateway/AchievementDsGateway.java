package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;

import java.util.Optional;

public interface AchievementDsGateway {

    Optional<AchievementRequestModel> getAchievementById(Integer id);

    Iterable<AchievementRequestModel> getAllAchievements();

    Boolean existsById(Integer id);

}