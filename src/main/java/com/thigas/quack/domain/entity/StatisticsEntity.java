package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsEntity implements BaseEntity {

    private int id;

    private UserEntity user;

    private int streakDays;

    private int bestStreak;

    private int userLevel;

    private Double userExperience;

    private int challengesCompletedCount;

    private int roadmapsCompletedCount;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }



}