package com.thigas.quack.UseCase.Model.Request;

import com.thigas.quack.Domain.Utils.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record UserLessonDtoRequestModel(Integer id, Integer userId, Integer lessonId, Integer status, String imagePath) {
}
