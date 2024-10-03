package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AchievementDTO {

    private int id;
    private String name;
    private String description;
    private String imagePath;
    private Set<Integer> userAchievements;

}