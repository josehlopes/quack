package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Mapper.LessonMapper;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class LessonService {

    private final LessonDsGateway lessonDsGateway;
    private final GenericPresenter genericPresenter;
    private final LessonMapper lessonMapper;

    public ResponseWrapper<GenericResponseModel> getById(int id) {
        Optional<LessonRequestModel> lesson = lessonDsGateway.getById(id);

        if (lesson.isEmpty()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Lesson not found"), 404);
        }

        Map<String, Object> payload = Map.of("lesson", lesson.get());
        return genericPresenter.prepareSuccessView(new GenericResponseModel("Lesson found", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> getAll() {
        Iterable<LessonRequestModel> lessons = lessonDsGateway.getAll();
        Iterable<LessonRequestModel> lessonList = StreamSupport.stream(lessons.spliterator(), false)
                .collect(Collectors.toList());

        if (!lessonList.iterator().hasNext()) {
            return genericPresenter.prepareFailView(new GenericResponseModel("No lessons available"), 204);
        }

        Map<String, Object> payload = Map.of("lessons", lessonList);
        return genericPresenter.prepareSuccessView(new GenericResponseModel("All lessons retrieved", payload), 200);
    }

    public ResponseWrapper<GenericResponseModel> existsById(int id) {
        boolean exists = lessonDsGateway.existsById(id);

        if (!exists) {
            return genericPresenter.prepareFailView(new GenericResponseModel("Lesson does not exist"), 404);
        }

        return genericPresenter.prepareSuccessView(new GenericResponseModel("Lesson exists"), 200);
    }

}