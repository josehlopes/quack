package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class LessonService {

    private final LessonDsGateway lessonDsGateway;

    public void create(LessonRequestModel lessonDtoRequest) {
        lessonDsGateway.save(lessonDtoRequest);
    }

    public Set<LessonRequestModel> createAll(Set<LessonRequestModel> lessonDtoRequests) {
        if (lessonDtoRequests == null || lessonDtoRequests.isEmpty()) {
            throw new IllegalArgumentException("LessonDtoRequests list cannot be null or empty");
        }

        Set<LessonRequestModel> savedLessons;
        try {
            savedLessons = lessonDsGateway.saveAll(lessonDtoRequests);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save lessons", e);
        }

        return savedLessons;
    }

    public Optional<LessonRequestModel> getById(int id) {
        return lessonDsGateway.findById(id);
    }

    public Iterable<LessonRequestModel> getAll() {
        Iterable<LessonRequestModel> lessons = lessonDsGateway.findAll();
        return StreamSupport.stream(lessons.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(LessonRequestModel lessonDtoRequest) {
        LessonRequestModel existingLesson = lessonDsGateway.findById(lessonDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
        LessonRequestModel updatedLesson = new LessonRequestModel(
                lessonDtoRequest.id(),
                lessonDtoRequest.title() != null ? lessonDtoRequest.title() : existingLesson.title(),
                lessonDtoRequest.description() != null ? lessonDtoRequest.description() : existingLesson.description(),
                lessonDtoRequest.language() != null ? lessonDtoRequest.language() : existingLesson.language(),
                lessonDtoRequest.imagePath() != null ? lessonDtoRequest.imagePath() : existingLesson.imagePath(),
                lessonDtoRequest.completed() != null ? lessonDtoRequest.completed() : existingLesson.completed(),
                lessonDtoRequest.link() != null ? lessonDtoRequest.link() : existingLesson.link(),
                lessonDtoRequest.stepsIds() != null ? lessonDtoRequest.stepsIds() : existingLesson.stepsIds()
        );
        lessonDsGateway.save(updatedLesson);
    }

    public void deleteLesson(int id) {
        lessonDsGateway.deleteById(id);
    }
}