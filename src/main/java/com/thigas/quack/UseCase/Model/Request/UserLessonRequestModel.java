package com.thigas.quack.UseCase.Model.Request;

public record UserLessonRequestModel(Integer id, Integer userId, Integer lessonId, Boolean completed) {
}
