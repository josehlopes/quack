
package com.thigas.quack.adapter.persistence.entity;

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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "streak_days")
    private Long streakDays;

    @Column(name = "best_streak ")
    private Long bestStreak;

    @Column(name = "level")
    private Long userLevel;

    @Column(name = "experience")
    private Double userExperience;

    @Column(name = "challenges_completed")
    private Long challengesCompleted;

    @Column(name = "lessons_completed")
    private Long lessonsCompleted;

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
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
     * @return Long return the streakDays
     */
    public Long getstreakDays() {
        return streakDays;
    }

    /**
     * @param streakDays the streakDays to set
     */
    public void setstreakDays(Long streakDays) {
        this.streakDays = streakDays;
    }

    /**
     * @return Long return the bestStreak
     */
    public Long getbestStreak() {
        return bestStreak;
    }

    /**
     * @param bestStreak the bestStreak to set
     */
    public void setbestStreak(Long bestStreak) {
        this.bestStreak = bestStreak;
    }

    /**
     * @return Long return the userLevel
     */
    public Long getUserLevel() {
        return userLevel;
    }

    /**
     * @param userLevel the userLevel to set
     */
    public void setUserLevel(Long userLevel) {
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
     * @return Long return the challengesCompleted
     */
    public Long getChallengesCompleted() {
        return challengesCompleted;
    }

    /**
     * @param challengesCompleted the challengesCompleted to set
     */
    public void setChallengesCompleted(Long challengesCompleted) {
        this.challengesCompleted = challengesCompleted;
    }

    /**
     * @return Long return the lessonsCompleted
     */
    public Long getLessonsCompleted() {
        return lessonsCompleted;
    }

    /**
     * @param lessonsCompleted the lessonsCompleted to set
     */
    public void setLessonsCompleted(Long lessonsCompleted) {
        this.lessonsCompleted = lessonsCompleted;
    }

}