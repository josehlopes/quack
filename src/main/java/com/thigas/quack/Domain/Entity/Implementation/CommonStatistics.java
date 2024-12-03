package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Statistics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonStatistics implements Statistics {

    private Integer id;
    private Integer userId;
    private Integer streakDays;
    private Integer bestStreak;
    private Integer level;
    private Integer nextLevel;
    private Double experience;
    private Double experienceToNextLevel;
    private Integer challengesCompletedCount;
    private Integer roadmapsCompletedCount;
    private Integer achievementsUnlockedCount;
    private Integer achievementsLockedCount;
    private Double points;


    @Override
    public Boolean setBestStreak(Integer streakDays) {
        if (streakDays > this.bestStreak) {
            this.bestStreak = streakDays;
            return true;
        }
        return false;
    }

    @Override
    public void addExperience(Double experience) {
        this.experience += experience;
        if (this.experience >= experienceToNextLevel) {
            this.level++;
            this.experienceToNextLevel = calculateExperienceToNextLevel(this.experience);
        }
    }

    @Override
    public void setNextLevel() {
        this.nextLevel = this.level + 1;
    }

    @Override
    public void setExperienceToNextLevel() {
        this.experienceToNextLevel = calculateExperienceToNextLevel(this.experience);
    }

    @Override
    public Double calculateExperienceToNextLevel(Double experience) {
        return 100.0 * Math.pow(1.1, this.level) - experience;
    }

    @Override
    public Boolean isLevelUp(Double experience) {
        return experience >= experienceToNextLevel;
    }

    @Override
    public void addPoints(Double points) {
        this.points += points;
    }

    @Override
    public void removePoints(Double points) {
        this.points -= points;
    }

}
