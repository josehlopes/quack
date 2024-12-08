package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Interface.UserAchievement;
import com.thigas.quack.Domain.Factory.Interface.UserAchievementFactory;
import com.thigas.quack.UseCase.Boundary.UserAchievementInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.UserAchievementMapper;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementUnlockRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@AllArgsConstructor
public class UserAchievementService implements UserAchievementInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(UserAchievementService.class);
    
    private final GenericPresenter genericPresenter;
    private final UserAchievementDsGateway userAchievementDsGateway;
    private final UserAchievementMapper userAchievementMapper;
    private final UserAchievementFactory userAchievementFactory;
    private final StatisticsService statisticsService;
    
    @Override
    public ResponseWrapper<GenericResponseModel> unlockUserAchievement(UserAchievementUnlockRequestModel userAchievementUnlockRequestModel) {
        try {
            if (!userAchievementDsGateway.findByUserIdAndAchievementId(userAchievementUnlockRequestModel.userId(), userAchievementUnlockRequestModel.achievementId())) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Achievement not found for user"), 404);
            }
            
            UserAchievement userAchievement = createUserAchievement(userAchievementUnlockRequestModel.userId(), userAchievementUnlockRequestModel.achievementId(), userAchievementUnlockRequestModel.description());
            statisticsService.addExperience(userAchievementUnlockRequestModel.userId(), 30.0);
            saveUserAchievement(userAchievement);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement unlocked successfully"), 200);
        } catch (Exception e) {
            logger.error("Error unlocking user achievement for user ID: {}", userAchievementUnlockRequestModel.userId(), e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error unlocking user achievement"), 500);
        }
    }
    
    private UserAchievement createUserAchievement(Integer userId, Integer achievementId, String description) {
        return userAchievementFactory.create(userId, achievementId, description);
    }
    
    private void saveUserAchievement(UserAchievement userAchievement) {
        try {
            UserAchievementRequestModel userAchievementRequestModel = userAchievementMapper.toDsModel(userAchievement);
            userAchievementDsGateway.saveUserAchievement(userAchievementRequestModel);
        } catch (Exception e) {
            logger.error("Error saving user achievement", e);
            throw new RuntimeException("Error saving user achievement");
        }
    }
    
    @Override
    public ResponseWrapper<GenericResponseModel> lockUserAchievement(Integer userAchievementId) {
        try {
            if (userAchievementDsGateway.getUserAchievementById(userAchievementId).isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("User achievement not found"), 404);
            }
            
            userAchievementDsGateway.lockUserAchievement(userAchievementId);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement locked successfully"), 200);
        } catch (Exception e) {
            logger.error("Error locking user achievement with ID: {}", userAchievementId, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error locking user achievement"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> getUserAchievementsByUserId(Integer userId) {
        try {
            Iterable<AchievementRequestModel> userAchievements = userAchievementDsGateway.getAllUserAchievements(userId);
            Map<String, Object> payload = Map.of("achievements", userAchievements);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievements found", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting user achievements for user ID: {}", userId, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting user achievements"), 500);
        }
    }
}