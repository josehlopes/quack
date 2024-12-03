package com.thigas.quack.Domain.Entity.Interface;


public interface Statistics {

    Integer getId();

    Integer getUserId();

    Integer getStreakDays();

    Integer getBestStreak();

    Integer getLevel();

    Integer getNextLevel();

    Double getExperience();

    Double getExperienceToNextLevel();

    Integer getChallengesCompletedCount();

    Integer getRoadmapsCompletedCount();

    Integer getAchievementsUnlockedCount();

    Integer getAchievementsLockedCount();

    Double getPoints();

    Boolean setBestStreak(Integer streakDays);
    void addExperience(Double experience);
    void setNextLevel();
    void setExperienceToNextLevel();
    Double calculateExperienceToNextLevel(Double experience);
    Boolean isLevelUp(Double experience);
    void addPoints(Double points);
    void removePoints(Double points);
}