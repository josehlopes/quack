package com.thigas.quack.UseCase.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

public record LessonDtoRequestModel(Integer id, String title, String description, String language, String imagePath, Boolean completed, String link, Set<Integer> stepsIds) {
}
