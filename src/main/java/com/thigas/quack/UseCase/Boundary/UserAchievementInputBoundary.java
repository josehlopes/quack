package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface UserAchievementInputBoundary {
    ResponseWrapper<GenericResponseModel> unlock(Integer userId, Integer achievementId);
    ResponseWrapper<GenericResponseModel> lock(Integer userAchievementId);
}
