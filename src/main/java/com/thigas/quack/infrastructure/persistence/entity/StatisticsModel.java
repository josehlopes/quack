package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import jakarta.persistence.*;


@Entity
@Table(name = "user_statistic")
public class StatisticsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @Column(name = "streak_days")
    private int streakDays;

    @Column(name = "best_streak")
    private int bestStreak;

    @Column(name = "level")
    private int userLevel;

    @Column(name = "experience")
    private Double userExperience;

    @Column(name = "challenges_completed_count")
    private int challengesCompletedCount;

    @Column(name = "roadmaps_completed_count")
    private int roadmapsCompletedCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
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
        return "StatisticsModel{" +
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
