package com.thigas.quack.UseCase.Model.Request;

public record UserAchievementUnlockRequestModel(Integer userId, Integer achievementId, String description) {
}
