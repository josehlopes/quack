package com.thigas.quack.Domain.Factory.Implementation;

import com.thigas.quack.Domain.Entity.Implementation.CommonStatistics;
import com.thigas.quack.Domain.Entity.Interface.Statistics;
import com.thigas.quack.Domain.Factory.Interface.StatisticsFactory;

public class CommonStatisticsFactory implements StatisticsFactory {
    @Override
    public Statistics create(Integer userId) {
        {
            Integer streakDays = 0;
            Integer bestStreak = 0;
            Integer level = 0;
            Integer nextLevel = 1;
            Double experience = 0.0;
            Double experienceToNextLevel = 100.0;
            Integer challengesCompletedCount = 0;
            Integer roadmapsCompletedCount = 0;
            Integer achievementsUnlockedCount = 0;
            Integer achievementsLockedCount = 0;
            Double points = 0.0;
            Boolean isActive = true;
            return new CommonStatistics(null, userId, streakDays, bestStreak, level, nextLevel, experience, experienceToNextLevel, challengesCompletedCount, roadmapsCompletedCount, achievementsUnlockedCount, achievementsLockedCount, points, isActive);
        }
    }
}
