package com.thigas.quack.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

}