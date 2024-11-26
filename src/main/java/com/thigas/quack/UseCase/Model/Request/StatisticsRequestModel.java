package com.thigas.quack.UseCase.Model.Request;


public record StatisticsRequestModel(Integer id, Integer userId, Integer streakDays, Integer bestStreak,
                                     Integer userLevel, Double points, Double userExperience,
                                     Integer challengesCompletedCount, Integer roadmapsCompletedCount) {
}