package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Model.Request.LessonDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.StepDtoRequestModel;
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

    public void create(StepDtoRequestModel stepDtoRequest) {
        stepDsGateway.save(stepDtoRequest);
    }

    public Optional<StepDtoRequestModel> getById(int id) {
        return stepDsGateway.findById(id);
    }

    public Iterable<StepDtoRequestModel> getAll() {
        Iterable<StepDtoRequestModel> steps = stepDsGateway.findAll();
        return StreamSupport.stream(steps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(StepDtoRequestModel stepDtoRequest) {
        StepDtoRequestModel existingStep = stepDsGateway.findById(stepDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("Step not found"));
        StepDtoRequestModel updatedStep = new StepDtoRequestModel(
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
        Optional<StepDtoRequestModel> optionalStep = stepDsGateway.findById(id);
        if (optionalStep.isPresent()) {
            StepDtoRequestModel step = optionalStep.get();
            step = new StepDtoRequestModel(
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

    public Set<LessonDtoRequestModel> verifyLessons(StepDtoRequestModel stepDto) {
        Set<LessonDtoRequestModel> lessonSet = new HashSet<>();

        if (stepDto.lessonsIds() == null || stepDto.lessonsIds().isEmpty()) {
            return lessonSet;
        }

        for (Integer lessonId : stepDto.lessonsIds()) {
            LessonDtoRequestModel lesson = lessonDsGateway.findById(lessonId)
                    .orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + lessonId));
            lessonSet.add(lesson);
        }
        return lessonSet;
    }

    public Boolean existsById(int userId) {
        return stepDsGateway.existsById(userId);
    }

    public void addLesson(StepDtoRequestModel step, Set<LessonDtoRequestModel> lessons) {
        // Implementation for adding lessons to a step
    }

    public void removeLesson(StepDtoRequestModel step, LessonDtoRequestModel lesson) {
        // Implementation for removing lessons from a step
    }
}