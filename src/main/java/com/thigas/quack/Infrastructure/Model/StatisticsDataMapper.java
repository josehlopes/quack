package com.thigas.quack.Infrastructure.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_statistic")
public class StatisticsDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDataMapper user;
    @Column(name = "streak_days")
    private int streakDays;
    @Column(name = "best_streak")
    private int bestStreak;
    @Column(name = "level")
    private int userLevel;
    @Column(name = "points", nullable = false)
    private Double points = 0.0;
    @Column(name = "experience")
    private Double userExperience;
    @Column(name = "challenges_completed_count")
    private int challengesCompletedCount;
    @Column(name = "roadmaps_completed_count")
    private int roadmapsCompletedCount;

    public StatisticsDataMapper(Integer id, UserDataMapper user, int streakDays, int bestStreak, int userLevel, Double points, Double userExperience, int challengesCompletedCount, int roadmapsCompletedCount) {
        this.id = id;
        this.user = user;
        this.streakDays = streakDays;
        this.bestStreak = bestStreak;
        this.userLevel = userLevel;
        this.points = points;
        this.userExperience = userExperience;
        this.challengesCompletedCount = challengesCompletedCount;
        this.roadmapsCompletedCount = roadmapsCompletedCount;
    }

    public StatisticsDataMapper() {

    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        StatisticsDataMapper that = (StatisticsDataMapper) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
