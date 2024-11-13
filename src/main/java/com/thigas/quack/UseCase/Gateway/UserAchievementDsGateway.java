package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserAchievementDtoRequestModel;

import java.util.Optional;

public interface UserAchievementDsGateway {
    void save(UserAchievementDtoRequestModel userAchievement);

    Optional<UserAchievementDtoRequestModel> findById(int id);

    boolean existsById(int id);

    Iterable<UserAchievementDtoRequestModel> findAll();

    void deleteById(int id);
}
