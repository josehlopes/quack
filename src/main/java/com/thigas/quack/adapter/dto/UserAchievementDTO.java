package com.thigas.quack.adapter.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserAchievementDTO {

    private int id;
    private int user;
    private String imagePath;
    private int achievement;
    private String obtainedDate;
}
