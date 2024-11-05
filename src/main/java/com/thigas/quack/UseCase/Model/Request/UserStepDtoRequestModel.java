package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record UserStepDtoRequestModel(Integer id, Integer userId, Integer stepId, Integer status, String imagePath) {
}
