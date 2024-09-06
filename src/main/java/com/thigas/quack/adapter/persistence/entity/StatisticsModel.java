
package com.thigas.quack.adapter.persistence.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "statistics")
public class StatisticsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "offensive_days")
    private Long offensiveDays;

    @Column(name = "best_offensive")
    private Long bestOffensive;

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
     * @return Long return the offensiveDays
     */
    public Long getOffensiveDays() {
        return offensiveDays;
    }

    /**
     * @param offensiveDays the offensiveDays to set
     */
    public void setOffensiveDays(Long offensiveDays) {
        this.offensiveDays = offensiveDays;
    }

    /**
     * @return Long return the bestOffensive
     */
    public Long getBestOffensive() {
        return bestOffensive;
    }

    /**
     * @param bestOffensive the bestOffensive to set
     */
    public void setBestOffensive(Long bestOffensive) {
        this.bestOffensive = bestOffensive;
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