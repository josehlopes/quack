package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserLessonDtoRequestModel;
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

    public void create(UserLessonDtoRequestModel userLessonDtoRequest) {
        userLessonDsGateway.save(userLessonDtoRequest);
    }

    public Optional<UserLessonDtoRequestModel> getById(int id) {
        return userLessonDsGateway.findById(id);
    }

    public Iterable<UserLessonDtoRequestModel> getAll() {
        Iterable<UserLessonDtoRequestModel> userLessons = userLessonDsGateway.findAll();
        return StreamSupport.stream(userLessons.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserLessonDtoRequestModel userLessonDtoRequest) {
        UserLessonDtoRequestModel existingUserLesson = userLessonDsGateway.findById(userLessonDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Lesson not found"));

        UserLessonDtoRequestModel updatedEntity = new UserLessonDtoRequestModel(
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