package com.thigas.quack.UseCase.Model.Request;

public record UserAchievementDtoRequestModel(Integer id, Integer userId, Integer achievementId, String imagePath,
                                             String obtainedDate, Integer status) {
}
