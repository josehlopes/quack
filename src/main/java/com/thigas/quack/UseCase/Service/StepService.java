package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Gateway.StepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class StepService {

    private final StepDsGateway stepDsGateway;
    private final LessonDsGateway lessonDsGateway;
    private final GenericPresenter genericPresenter;



    public Optional<StepRequestModel> getById(Integer id) {
        return stepDsGateway.getStepById(id);
    }

    public Iterable<StepRequestModel> getAll() {
        Iterable<StepRequestModel> steps = stepDsGateway.getAllSteps();
        return StreamSupport.stream(steps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public ResponseWrapper<GenericResponseModel> getStepsByRoadmapId(Integer roadmapId) {
        try {
            List<StepRequestModel> steps = stepDsGateway.getStepsByRoadmapId(roadmapId);

            if (steps.isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("No steps found for the given roadmap"), 404);
            }

            Map<String, Object> payload = Map.of("steps", steps);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Steps retrieved successfully", payload), 200);
        } catch (Exception e) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting steps by roadmap ID"), 500);
        }
    }



//
//    public void updateStatus(Integer id, Integer statusValue) {
//        Optional<StepRequestModel> optionalStep = stepDsGateway.getAchievementById(id);
//        if (optionalStep.isPresent()) {
//            StepRequestModel step = optionalStep.get();
//            step = new StepRequestModel(
//                    step.id(),
//                    step.roadmapsIds(),
//                    step.lessonsIds(),
//                    step.tasksIds(),
//                    step.description(),
//                    step.imagePath(),
//                    statusValue
//            );
//            stepDsGateway.saveUserRoadmap(step);
//        } else {
//            throw new IllegalArgumentException("Step not found with id: " + id);
//        }
//    }

//    public Set<LessonRequestModel> verifyLessons(StepRequestModel stepDto) {
//        Set<LessonRequestModel> lessonSet = new HashSet<>();
//
//        if (stepDto.lessonsIds() == null || stepDto.lessonsIds().isEmpty()) {
//            return lessonSet;
//        }
//
//        for (Integer lessonId : stepDto.lessonsIds()) {
//            LessonRequestModel lesson = lessonDsGateway.getUserRoadmapById(lessonId)
//                    .orElseThrow(() -> new RuntimeException("Lesson not found with ID: " + lessonId));
//            lessonSet.add(lesson);
//        }
//        return lessonSet;
//    }

    public Boolean existsById(Integer userId) {
        return stepDsGateway.existsById(userId);
    }

//    public void addLesson(StepRequestModel step, Set<LessonRequestModel> lessons) {
//        // Implementation for adding lessons to a step
//    }
//
//    public void removeLesson(StepRequestModel step, LessonRequestModel lesson) {
//        // Implementation for removing lessons from a step
//    }
}