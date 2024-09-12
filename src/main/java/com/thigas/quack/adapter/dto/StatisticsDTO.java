package com.thigas.quack.adapter.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDTO {

    private int id;

    private int userId;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompleted;

    private int lessonsCompleted;
}