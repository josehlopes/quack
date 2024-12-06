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

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class UserAchievementService implements UserAchievementInputBoundary {

    private final GenericPresenter genericPresenter;
    private final UserAchievementDsGateway userAchievementDsGateway;
    private final UserAchievementMapper userAchievementMapper;
    private final UserAchievementFactory userAchievementFactory;
    private final StatisticsService statisticsService;

    //TODO: RETORNANDO ERRO 500 ATÉ QUANDO A OPERAÇÃO É FEITA COM SUCESSO
    @Override
    public ResponseWrapper<GenericResponseModel> unlockUserAchievement(UserAchievementUnlockRequestModel userAchievementUnlockRequestModel) {
        if (!userAchievementDsGateway.findByUserIdAndAchievementId(userAchievementUnlockRequestModel.userId(), userAchievementUnlockRequestModel.achievementId())) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Achievement not found for user"), 404);
        }

        UserAchievement userAchievement = createUserAchievement(userAchievementUnlockRequestModel.userId(), userAchievementUnlockRequestModel.achievementId(), userAchievementUnlockRequestModel.description());
        statisticsService.addExperience(userAchievementUnlockRequestModel.userId(), 10.0);
        saveUserAchievement(userAchievement);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement unlocked successfully"), 200);
    }

    private UserAchievement createUserAchievement(Integer userId, Integer achievementId, String description) {
        return userAchievementFactory.create(userId, achievementId, description);
    }

    private void saveUserAchievement(UserAchievement userAchievement) {
        UserAchievementRequestModel userAchievementRequestModel = userAchievementMapper.toDsModel(userAchievement);
        userAchievementDsGateway.save(userAchievementRequestModel);
    }

    @Override
    public ResponseWrapper<GenericResponseModel> lockUserAchievement(Integer userAchievementId) {
        if (userAchievementDsGateway.getUserAchievementById(userAchievementId).isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("User achievement not found"), 404);
        }

        userAchievementDsGateway.lockUserAchievement(userAchievementId);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement locked successfully"), 200);
    }

    public ResponseWrapper<GenericResponseModel> getUserAchievementsByUserId(Integer userId) {
        Iterable<AchievementRequestModel> userAchievements = userAchievementDsGateway.getAllUserAchievements(userId);
        Map<String, Object> payload = Map.of("achievements", userAchievements);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievements found", payload), 200);
    }
}