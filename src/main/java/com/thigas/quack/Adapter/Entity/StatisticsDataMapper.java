package com.thigas.quack.Adapter.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_statistic")
public class StatisticsDataMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserDataMapper user;
    @Column(name = "streak_days")
    private Integer streakDays;
    @Column(name = "best_streak")
    private Integer bestStreak;
    @Column(name = "level")
    private Integer level;
    @Column(name = "next_level")
    private Integer nextLevel;
    @Column(name = "experience")
    private Double experience;
    @Column(name = "experience_to_next_level")
    private Double experienceToNextLevel;
    @Column(name = "challenges_completed_count")
    private Integer challengesCompletedCount;
    @Column(name = "roadmaps_completed_count")
    private Integer roadmapsCompletedCount;
    @Column(name = "achievements_unlocked_count")
    private Integer achievementsUnlockedCount;
    @Column(name = "achievements_locked_count")
    private Integer achievementsLockedCount;
    @Column(name = "points", nullable = false)
    private Double points = 0.0;
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

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
