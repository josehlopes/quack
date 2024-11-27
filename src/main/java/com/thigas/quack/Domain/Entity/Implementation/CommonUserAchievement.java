package com.thigas.quack.Domain.Entity.Implementation;


import com.thigas.quack.Domain.Entity.Interface.UserAchievement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonUserAchievement implements UserAchievement {

    private Integer id;
    private Integer userId;
    private Integer achievementId;
    private String description;
    private OffsetDateTime obtainedOn;
    private Boolean isActive;

}
