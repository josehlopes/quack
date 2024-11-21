package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;

import java.util.Optional;

public interface AchievementDsGateway {

    void save(AchievementRequestModel achievement);

    Optional<AchievementRequestModel> findById(int id);

    Iterable<AchievementRequestModel> findAll();

    void deleteById(int id);

    Boolean existsById(int id);

}