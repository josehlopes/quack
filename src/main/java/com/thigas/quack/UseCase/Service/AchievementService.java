package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AchievementService {

    private final AchievementDsGateway achievementDsGateway;
    private final GenericPresenter genericPresenter;

    public Optional<AchievementRequestModel> getById(Integer id) {
        return achievementDsGateway.getAchievementById(id);
    }

    public Iterable<AchievementRequestModel> getAll() {
        Iterable<AchievementRequestModel> achievements = achievementDsGateway.getAllAchievements();
        return StreamSupport.stream(achievements.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Boolean existsById(Integer achievementId) {
        return achievementDsGateway.existsById(achievementId);
    }

}
