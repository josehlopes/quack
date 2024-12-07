package com.thigas.quack.UseCase.Model.Response;

public record StatisticsInfoResponseModel(Integer id, Integer userId, Integer streakDays, Integer bestStreak,
                                          Integer level, Integer nextLevel, Double points, Double experience,
                                          Double experienceToNextLevel, Integer challengesCompletedCount,
                                          Integer roadmapsCompletedCount, Integer achievementsUnlockedCount,
                                          Integer achievementsLockedCount) {
}
