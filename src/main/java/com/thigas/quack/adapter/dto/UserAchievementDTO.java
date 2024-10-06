package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserAchievementDTO {

    private int id;
    private int user;
    private Set<Integer> achievements;
    private String imagePath;
}
