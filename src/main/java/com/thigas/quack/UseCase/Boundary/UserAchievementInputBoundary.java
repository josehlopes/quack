package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.UserAchievementUnlockRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface UserAchievementInputBoundary {
    ResponseWrapper<GenericResponseModel> unlockUserAchievement(UserAchievementUnlockRequestModel request);
    ResponseWrapper<GenericResponseModel> lockUserAchievement(Integer userAchievementId);
}
