package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserLessonService {

    private final UserLessonDsGateway userLessonDsGateway;

    private final LessonService lessonService;

    private final UserService userService;

    public void create(UserLessonRequestModel userLessonDtoRequest) {
        userLessonDsGateway.save(userLessonDtoRequest);
    }

    public Optional<UserLessonRequestModel> getById(int id) {
        return userLessonDsGateway.findById(id);
    }

    public Iterable<UserLessonRequestModel> getAll() {
        Iterable<UserLessonRequestModel> userLessons = userLessonDsGateway.findAll();
        return StreamSupport.stream(userLessons.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserLessonRequestModel userLessonDtoRequest) {
        UserLessonRequestModel existingUserLesson = userLessonDsGateway.findById(userLessonDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Lesson not found"));

        UserLessonRequestModel updatedEntity = new UserLessonRequestModel(
                userLessonDtoRequest.id(),
                userLessonDtoRequest.userId() != null ? userLessonDtoRequest.userId() : existingUserLesson.userId(),
                userLessonDtoRequest.lessonId() != null ? userLessonDtoRequest.lessonId() : existingUserLesson.lessonId(),
                userLessonDtoRequest.status() != null ? userLessonDtoRequest.status() : existingUserLesson.status(),
                userLessonDtoRequest.imagePath() != null ? userLessonDtoRequest.imagePath() : existingUserLesson.imagePath()
        );

        userLessonDsGateway.save(updatedEntity);
    }

    public void delete(int id) {
        userLessonDsGateway.deleteById(id);
    }
}