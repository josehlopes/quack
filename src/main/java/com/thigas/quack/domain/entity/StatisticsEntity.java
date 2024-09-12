package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.entity.UserEntity;

public class StatisticsEntity {

    private int id;

    private UserEntity user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompleted;

    private int lessonsCompleted;

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return UserEntity return the user
     */
    public UserEntity getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserEntity user) {
        this.user = user;
    }

    /**
     * @return int return the streakDays
     */
    public int getStreakDays() {
        return streakDays;
    }

    /**
     * @param streakDays the streakDays to set
     */
    public void setStreakDays(int streakDays) {
        this.streakDays = streakDays;
    }

    /**
     * @return int return the bestStreak
     */
    public int getBestStreak() {
        return bestStreak;
    }

    /**
     * @param bestStreak the bestStreak to set
     */
    public void setBestStreak(int bestStreak) {
        this.bestStreak = bestStreak;
    }

    /**
     * @return int return the userLevel
     */
    public int getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel the userLevel to set
     */
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * @return Double return the userExperience
     */
    public Double getUserExperience() {
        return userExperience;
    }

    /**
     * @param userExperience the userExperience to set
     */
    public void setUserExperience(Double userExperience) {
        this.userExperience = userExperience;
    }

    /**
     * @return int return the challengesCompleted
     */
    public int getChallengesCompleted() {
        return challengesCompleted;
    }

    /**
     * @param challengesCompleted the challengesCompleted to set
     */
    public void setChallengesCompleted(int challengesCompleted) {
        this.challengesCompleted = challengesCompleted;
    }

    /**
     * @return int return the lessonsCompleted
     */
    public int getLessonsCompleted() {
        return lessonsCompleted;
    }

    /**
     * @param lessonsCompleted the lessonsCompleted to set
     */
    public void setLessonsCompleted(int lessonsCompleted) {
        this.lessonsCompleted = lessonsCompleted;
    }

}