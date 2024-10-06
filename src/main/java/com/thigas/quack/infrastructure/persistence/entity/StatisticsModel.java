package com.thigas.quack.infrastructure.persistence.entity;

import com.thigas.quack.adapter.model.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "statistic")
public class StatisticsModel implements BaseModel {

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
    
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        StatisticsModel that = (StatisticsModel) o;
        return getId() != 0 && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
