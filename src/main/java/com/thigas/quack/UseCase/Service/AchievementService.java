package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AchievementService {

    private final AchievementDsGateway achievementDsGateway;

    public void create(AchievementDtoRequestModel achievementDtoRequest) {
        achievementDsGateway.save(achievementDtoRequest);
    }

    public Optional<AchievementDtoRequestModel> getById(int id) {
        return achievementDsGateway.findById(id);
    }

    public Iterable<AchievementDtoRequestModel> getAll() {
        Iterable<AchievementDtoRequestModel> achievements = achievementDsGateway.findAll();
        return StreamSupport.stream(achievements.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(AchievementDtoRequestModel achievementDtoRequest) {
        AchievementDtoRequestModel existingAchievement = achievementDsGateway.findById(achievementDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Achievement not found"));
        AchievementDtoRequestModel updatedAchievement = new AchievementDtoRequestModel(
                achievementDtoRequest.id(),
                achievementDtoRequest.name() != null ? achievementDtoRequest.name() : existingAchievement.name(),
                achievementDtoRequest.description() != null ? achievementDtoRequest.description() : existingAchievement.description(),
                achievementDtoRequest.imagePath() != null ? achievementDtoRequest.imagePath() : existingAchievement.imagePath()
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
