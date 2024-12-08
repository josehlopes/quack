package com.thigas.quack.UseCase.Service;

import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Mapper.LessonMapper;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class LessonService {
    
    private static final Logger logger = LoggerFactory.getLogger(LessonService.class);
    
    private final LessonDsGateway lessonDsGateway;
    private final GenericPresenter genericPresenter;
    private final LessonMapper lessonMapper;
    
    public ResponseWrapper<GenericResponseModel> getById(int id) {
        try {
            Optional<LessonRequestModel> lesson = lessonDsGateway.getLessonById(id);
            
            if (lesson.isEmpty()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Lesson not found"), 404);
            }
            
            Map<String, Object> payload = Map.of("lesson", lesson.get());
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Lesson found", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting lesson by ID: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting lesson"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> getAll() {
        try {
            Iterable<LessonRequestModel> lessons = lessonDsGateway.getAllLessons();
            Iterable<LessonRequestModel> lessonList = StreamSupport.stream(lessons.spliterator(), false)
                    .collect(Collectors.toList());
            
            if (!lessonList.iterator().hasNext()) {
                return genericPresenter.prepareFailView(new GenericResponseModel("No lessons available"), 204);
            }
            
            Map<String, Object> payload = Map.of("lessons", lessonList);
            return genericPresenter.prepareSuccessView(new GenericResponseModel("All lessons retrieved", payload), 200);
        } catch (Exception e) {
            logger.error("Error getting all lessons", e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error getting all lessons"), 500);
        }
    }
    
    public ResponseWrapper<GenericResponseModel> existsById(int id) {
        try {
            boolean exists = lessonDsGateway.existsById(id);
            
            if (!exists) {
                return genericPresenter.prepareFailView(new GenericResponseModel("Lesson does not exist"), 404);
            }
            
            return genericPresenter.prepareSuccessView(new GenericResponseModel("Lesson exists"), 200);
        } catch (Exception e) {
            logger.error("Error checking if lesson exists by ID: {}", id, e);
            return genericPresenter.prepareFailView(new GenericResponseModel("Error checking if lesson exists"), 500);
        }
    }
}