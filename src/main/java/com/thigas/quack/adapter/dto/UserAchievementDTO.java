package com.thigas.quack.adapter.dto;

import lombok.Data;

@Data
public class UserAchievementDTO {

    private int id;
    private int user;
    private int achievement;
    private String earnedAt;

}
