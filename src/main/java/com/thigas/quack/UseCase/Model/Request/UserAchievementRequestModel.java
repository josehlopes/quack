package com.thigas.quack.UseCase.Model.Request;

public record UserAchievementRequestModel(Integer id, Integer userId, Integer achievementId, String description,
                                          String obtainedOn, Boolean isActive) {
}
