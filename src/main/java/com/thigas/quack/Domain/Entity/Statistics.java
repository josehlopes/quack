package com.thigas.quack.Domain.Entity;


public interface Statistics {

    int getId();

    User getUser();

    int getStreakDays();

    int getBestStreak();

    int getUserLevel();

    Double getUserExperience();

    int getChallengesCompletedCount();

    int getRoadmapsCompletedCount();

}