package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;


public class StatisticsEntity implements BaseEntity {

    private int id;

    private UserEntity user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompletedCount;

    private int roadmapsCompletedCount;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getStreakDays() {
        return streakDays;
    }

    public void setStreakDays(int streakDays) {
        this.streakDays = streakDays;
    }

    public int getBestStreak() {
        return bestStreak;
    }

    public void setBestStreak(int bestStreak) {
        this.bestStreak = bestStreak;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public Double getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(Double userExperience) {
        this.userExperience = userExperience;
    }

    public int getChallengesCompletedCount() {
        return challengesCompletedCount;
    }

    public void setChallengesCompletedCount(int challengesCompletedCount) {
        this.challengesCompletedCount = challengesCompletedCount;
    }

    public int getRoadmapsCompletedCount() {
        return roadmapsCompletedCount;
    }

    public void setRoadmapsCompletedCount(int roadmapsCompletedCount) {
        this.roadmapsCompletedCount = roadmapsCompletedCount;
    }

    @Override
    public String toString() {
        return "StatisticsEntity{" +
                "id=" + id +
                ", user=" + user +
                ", streakDays=" + streakDays +
                ", bestStreak=" + bestStreak +
                ", userLevel=" + userLevel +
                ", userExperience=" + userExperience +
                ", challengesCompletedCount=" + challengesCompletedCount +
                ", roadmapsCompletedCount=" + roadmapsCompletedCount +
                '}';
    }
}