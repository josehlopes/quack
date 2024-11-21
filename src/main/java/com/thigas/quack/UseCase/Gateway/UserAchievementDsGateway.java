package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;

import java.util.Optional;

public interface UserAchievementDsGateway {
    void save(UserAchievementRequestModel userAchievement);

    Optional<UserAchievementRequestModel> findById(int id);

    boolean existsById(int id);

    Iterable<UserAchievementRequestModel> findAll();

    void deleteById(int id);
}
