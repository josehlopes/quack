package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class LessonService {

    private final LessonDsGateway lessonDsGateway;

    public void create(LessonDtoRequestModel lessonDtoRequest) {
        lessonDsGateway.save(lessonDtoRequest);
    }

    public Set<LessonDtoRequestModel> createAll(Set<LessonDtoRequestModel> lessonDtoRequests) {
        if (lessonDtoRequests == null || lessonDtoRequests.isEmpty()) {
            throw new IllegalArgumentException("LessonDtoRequests list cannot be null or empty");
        }

        Set<LessonDtoRequestModel> savedLessons;
        try {
            savedLessons = lessonDsGateway.saveAll(lessonDtoRequests);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save lessons", e);
        }

        return savedLessons;
    }

    public Optional<LessonDtoRequestModel> getById(int id) {
        return lessonDsGateway.findById(id);
    }

    public Iterable<LessonDtoRequestModel> getAll() {
        Iterable<LessonDtoRequestModel> lessons = lessonDsGateway.findAll();
        return StreamSupport.stream(lessons.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(LessonDtoRequestModel lessonDtoRequest) {
        LessonDtoRequestModel existingLesson = lessonDsGateway.findById(lessonDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
        LessonDtoRequestModel updatedLesson = new LessonDtoRequestModel(
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