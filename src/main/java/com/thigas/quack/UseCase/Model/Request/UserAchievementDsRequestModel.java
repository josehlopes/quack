package com.thigas.quack.UseCase.Model.Request;

public record UserAchievementDsRequestModel(Integer id, Integer userId, Integer achievementId, String description,
                                            String obtainedOn, Integer isActive) {
}
