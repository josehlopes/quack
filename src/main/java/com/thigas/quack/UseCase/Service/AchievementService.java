package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AchievementService {
    
    private static final Logger logger = LoggerFactory.getLogger(AchievementService.class);
    
    private final AchievementDsGateway achievementDsGateway;
    private final GenericPresenter genericPresenter;
    
    public Optional<AchievementRequestModel> getById(Integer id) {
        try {
            return achievementDsGateway.getAchievementById(id);
        } catch (Exception e) {
            logger.error("Error getting Achievement by ID: {}", id, e);
            return Optional.empty();
        }
    }
    
    public Iterable<AchievementRequestModel> getAll() {
        try {
            Iterable<AchievementRequestModel> achievements = achievementDsGateway.getAllAchievements();
            return StreamSupport.stream(achievements.spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all Achievements", e);
            return Collections.emptyList();
        }
    }
    
    public Boolean existsById(Integer achievementId) {
        try {
            return achievementDsGateway.existsById(achievementId);
        } catch (Exception e) {
            logger.error("Error checking if Achievement exists by ID: {}", achievementId, e);
            return false;
        }
    }
}