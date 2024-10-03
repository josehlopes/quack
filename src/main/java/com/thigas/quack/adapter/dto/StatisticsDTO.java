package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StatisticsDTO {

    private int id;
    private int user;
    private int streakDays;
    private int bestStreak;
    private int userLevel;
    private Double userExperience;
    private int challengesCompletedCount;
    private int roadmapsCompletedCount;
    private Set<Integer> roadmapsCompleted;
    private Set<Integer> stepsCompleted;

}