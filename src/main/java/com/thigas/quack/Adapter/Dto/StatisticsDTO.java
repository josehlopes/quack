package com.thigas.quack.Adapter.Dto;

import lombok.Data;

@Data
public class StatisticsDTO {

    private int id;
    private UserDTO user;
    private int streakDays;
    private int bestStreak;
    private int userLevel;
    private Double userExperience;
    private int challengesCompletedCount;
    private int roadmapsCompletedCount;
    private Double points;


}