package com.thigas.quack.UseCase.Model.Request;

import java.util.Set;

public record LessonDtoRequestModel(Integer id, String title, String description, String language, String imagePath,
                                    Boolean completed, String link, Set<Integer> stepsIds) {
}
