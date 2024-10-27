package com.thigas.quack.adapter.dto;

import com.thigas.quack.domain.model.Status;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class UserAchievementDTO {

    private int id;
    private UserDTO user;
    private String imagePath;
    private AchievementDTO achievement;
    private OffsetDateTime obtainedDate;
    private Status status;

}
