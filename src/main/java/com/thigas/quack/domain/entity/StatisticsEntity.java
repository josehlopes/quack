package com.thigas.quack.domain.entity;

import com.thigas.quack.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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