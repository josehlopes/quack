package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAchievementDsRequestModel {

    private int id;
    private UserDsRequestModel user;
    private AchievementDsRequestModel achievement;
    private String imagePath;
    private OffsetDateTime obtainedDate;
    private Status status;

}
