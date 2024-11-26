package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AchievementService {

    private final AchievementDsGateway achievementDsGateway;

    public void create(AchievementRequestModel achievementRequest) {
        achievementDsGateway.save(achievementRequest);
    }

    public Optional<AchievementRequestModel> getById(int id) {
        return achievementDsGateway.findById(id);
    }

    public Iterable<AchievementRequestModel> getAll() {
        Iterable<AchievementRequestModel> achievements = achievementDsGateway.findAll();
        return StreamSupport.stream(achievements.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(AchievementRequestModel achievementRequest) {
        AchievementRequestModel existingAchievement = achievementDsGateway.findById(achievementRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Achievement not found"));
        AchievementRequestModel updatedAchievement = new AchievementRequestModel(
                achievementRequest.id(),
                achievementRequest.name() != null ? achievementRequest.name() : existingAchievement.name(),
                achievementRequest.description() != null ? achievementRequest.description() : existingAchievement.description(),
                achievementRequest.imagePath() != null ? achievementRequest.imagePath() : existingAchievement.imagePath()
        );
        achievementDsGateway.save(updatedAchievement);
    }

    public void delete(int id) {
        achievementDsGateway.deleteById(id);
    }

    public Boolean existsById(int achievementId) {
        return achievementDsGateway.existsById(achievementId);
    }

}
