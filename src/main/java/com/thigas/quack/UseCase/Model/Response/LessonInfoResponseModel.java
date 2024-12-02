package com.thigas.quack.UseCase.Model.Response;

import java.util.Set;

public record LessonInfoResponseModel(Integer id, String title, String description, String language, String imagePath,
                                      Boolean completed, String link, Set<Integer> stepsId) {
}
