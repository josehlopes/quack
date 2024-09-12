
package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "statistic")
public class StatisticsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "streak_days")
    private int streakDays;

    @Column(name = "best_streak ")
    private int bestStreak;

    @Column(name = "level")
    private int userLevel;

    @Column(name = "experience")
    private Double userExperience;

    @Column(name = "challenges_completed")
    private int challengesCompleted;

    @Column(name = "lessons_completed")
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
     * @return UserModel return the user
     */
    public UserModel getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(UserModel user) {
        this.user = user;
    }

    /**
     * @return int return the streakDays
     */
    public int getstreakDays() {
        return streakDays;
    }

    /**
     * @param streakDays the streakDays to set
     */
    public void setstreakDays(int streakDays) {
        this.streakDays = streakDays;
    }

    /**
     * @return int return the bestStreak
     */
    public int getbestStreak() {
        return bestStreak;
    }

    /**
     * @param bestStreak the bestStreak to set
     */
    public void setbestStreak(int bestStreak) {
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