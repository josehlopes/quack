package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Boundary.UserAchievementInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.UserAchievementMapper;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserAchievementService implements UserAchievementInputBoundary {

    private final GenericPresenter genericPresenter;
    private final UserAchievementDsGateway userAchievementDsGateway;
    private final UserAchievementMapper userAchievementMapper;


    @Override
    public ResponseWrapper<GenericResponseModel> unlock(Integer userId, Integer achievementId) {
        if (!userAchievementDsGateway.existsUserAchievementByUserIdAndAchievementId(userId, achievementId)) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Achievement not found for user"), 404);
        }

        userAchievementDsGateway.unlockUserAchievement(userId, achievementId);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement unlocked successfully"), 200);
    }

    @Override
    public ResponseWrapper<GenericResponseModel> lock(Integer userAchievementId) {
        if (!userAchievementDsGateway.existsUserAchievementById(userAchievementId)) {
            return genericPresenter.prepareFailView(new GenericResponseModel("User achievement not found"), 404);
        }

        userAchievementDsGateway.lockUserAchievement(userAchievementId);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Achievement locked successfully"), 200);
    }
}