package com.thigas.quack.adapter.dto;

public class StatisticsDTO {

    private int id;

    private int user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompletedCount;

    private int roadmapsCompletedCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
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
        return "StatisticsDTO{" +
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