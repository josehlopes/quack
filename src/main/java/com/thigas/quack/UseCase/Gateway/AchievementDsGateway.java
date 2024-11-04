package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Model.AchievementDataMapper;

import java.util.Optional;

public interface AchievementDsGateway {

    void save(AchievementDataMapper achievement);
    Optional<AchievementDataMapper> findById(int id);
    Iterable<AchievementDataMapper> findAll();
    void deleteById(int id);
    Boolean existsById(int id);

}