package com.thigas.quack.Domain.Entity.Implementation;

import com.thigas.quack.Domain.Entity.Interface.Statistics;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonStatistics implements Statistics {

    private static final Logger logger = LoggerFactory.getLogger(CommonStatistics.class);

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
    public void updateBestStreak(Integer streakDays) {
        if (streakDays > this.bestStreak) {
            logger.info("Definindo melhor streak para {} dias.", streakDays);
            this.bestStreak = streakDays;
        }
    }

    @Override
    public void addExperience(Double experience) {
        logger.debug("Adicionando {} de experiência.", experience);
        this.experience += experience;
        while (this.experience >= experienceToNextLevel) {
            this.level++;
            this.experience -= experienceToNextLevel;
            this.experienceToNextLevel = calculateExperienceToNextLevel(Double.valueOf(this.level));
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
    public Boolean isLevelUp(Double additionalExperience) {
        return (this.experience + additionalExperience) >= this.experienceToNextLevel;
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
