package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class StepService {

    private final StepDsGateway stepDsGateway;

    private final LessonDsGateway lessonDsGateway;

    public void create(StepRequestModel stepDtoRequest) {
        stepDsGateway.save(stepDtoRequest);
    }

    public Optional<StepRequestModel> getById(int id) {
        return stepDsGateway.findById(id);
    }

    public Iterable<StepRequestModel> getAll() {
        Iterable<StepRequestModel> steps = stepDsGateway.findAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(StepRequestModel stepDtoRequest) {
        StepRequestModel existingStep = stepDsGateway.findById(stepDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Step not found"));
        StepRequestModel updatedStep = new StepRequestModel(
                stepDtoRequest.id(),
                stepDtoRequest.roadmapsIds() != null ? stepDtoRequest.roadmapsIds() : existingStep.roadmapsIds(),
                stepDtoRequest.lessonsIds() != null ? stepDtoRequest.lessonsIds() : existingStep.lessonsIds(),
                stepDtoRequest.tasksIds() != null ? stepDtoRequest.tasksIds() : existingStep.tasksIds(),
                stepDtoRequest.description() != null ? stepDtoRequest.description() : existingStep.description(),
                stepDtoRequest.imagePath() != null ? stepDtoRequest.imagePath() : existingStep.imagePath(),
                stepDtoRequest.status() != null ? stepDtoRequest.status() : existingStep.status()
        );
        stepDsGateway.save(updatedStep);
    }

    public void delete(int id) {
        stepDsGateway.deleteById(id);
    }

    public void updateStatus(Integer id, int statusValue) {
        Optional<StepRequestModel> optionalStep = stepDsGateway.findById(id);
        if (optionalStep.isPresent()) {
            StepRequestModel step = optionalStep.get();
            step = new StepRequestModel(
                    step.id(),
                    step.roadmapsIds(),
                    step.lessonsIds(),
                    step.tasksIds(),
                    step.description(),
                    step.imagePath(),
                    statusValue
            );
            stepDsGateway.save(step);
        } else {
            throw new IllegalArgumentException("Step not found with id: " + id);
        }
    }

    public Set<LessonRequestModel> verifyLessons(StepRequestModel stepDto) {
        Set<LessonRequestModel> lessonSet = new HashSet<>();

        if (stepDto.lessonsIds() == null || stepDto.lessonsIds().isEmpty()) {
            return lessonSet;
        }

        for (Integer lessonId : stepDto.lessonsIds()) {
            LessonRequestModel lesson = lessonDsGateway.getById(lessonId)
                    .orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + lessonId));
            lessonSet.add(lesson);
        }
        return lessonSet;
    }

    public Boolean existsById(int userId) {
        return stepDsGateway.existsById(userId);
    }

    public void addLesson(StepRequestModel step, Set<LessonRequestModel> lessons) {
        // Implementation for adding lessons to a step
    }

    public void removeLesson(StepRequestModel step, LessonRequestModel lesson) {
        // Implementation for removing lessons from a step
    }
}