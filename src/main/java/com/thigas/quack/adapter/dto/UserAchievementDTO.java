package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserAchievementDTO {

    private int id;
    private int user;
    private String imagePath;
    private int achievement;
    private String obtainedDate;
}
