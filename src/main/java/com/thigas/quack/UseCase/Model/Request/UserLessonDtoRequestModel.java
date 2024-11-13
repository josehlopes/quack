package com.thigas.quack.UseCase.Model.Request;

public record UserLessonDtoRequestModel(Integer id, Integer userId, Integer lessonId, Integer status,
                                        String imagePath) {
}
