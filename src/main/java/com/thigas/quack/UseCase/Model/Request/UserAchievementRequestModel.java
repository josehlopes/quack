package com.thigas.quack.UseCase.Model.Request;

public record UserAchievementRequestModel(Integer id, Integer userId, Integer achievementId, String imagePath,
                                          String obtainedDate, Integer status) {
}
