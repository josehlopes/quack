package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.Address.AchievementDtoRequestModel;

import java.util.Optional;

public interface AchievementDsGateway {

    void save(AchievementDtoRequestModel achievement);

    Optional<AchievementDtoRequestModel> findById(int id);

    Iterable<AchievementDtoRequestModel> findAll();

    void deleteById(int id);

    Boolean existsById(int id);

}