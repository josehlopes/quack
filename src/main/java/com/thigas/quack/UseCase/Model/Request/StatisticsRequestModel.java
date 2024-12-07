package com.thigas.quack.UseCase.Model.Request;

public record StatisticsRequestModel(Integer id, Integer userId, Integer streakDays, Integer bestStreak,
                                     Integer level, Integer nextLevel, Double points, Double experience,
                                     Double experienceToNextLevel, Integer challengesCompletedCount,
                                     Integer roadmapsCompletedCount, Integer achievementsUnlockedCount,
                                     Integer achievementsLockedCount, Boolean isActive) {
}