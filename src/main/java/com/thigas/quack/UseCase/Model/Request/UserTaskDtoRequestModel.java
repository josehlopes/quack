package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public record UserTaskDtoRequestModel(Integer id, Integer userId, Integer taskId, Integer status, String imagePath) {
}