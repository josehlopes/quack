package com.thigas.quack.domain.entity;

import com.thigas.quack.domain.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsEntity {

    private int id;

    private UserEntity user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompleted;

    private int lessonsCompleted;

}