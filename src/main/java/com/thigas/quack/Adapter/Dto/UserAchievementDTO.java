package com.thigas.quack.Adapter.Dto;

import com.thigas.quack.Domain.Utils.Status;
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
