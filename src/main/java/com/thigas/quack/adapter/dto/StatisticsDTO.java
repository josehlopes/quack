package com.thigas.quack.adapter.dto;

import lombok.Data;

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

}