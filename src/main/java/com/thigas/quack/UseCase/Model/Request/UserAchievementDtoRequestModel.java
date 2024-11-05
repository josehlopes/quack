package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;


public record UserAchievementDtoRequestModel(Integer id, Integer userId, Integer achievementId, String imagePath, String obtainedDate, Integer status) {
}
