package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsDsRequestModel {

    private int id;

    private UserDsRequestModel user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompletedCount;

    private int roadmapsCompletedCount;

    private Double points;

}