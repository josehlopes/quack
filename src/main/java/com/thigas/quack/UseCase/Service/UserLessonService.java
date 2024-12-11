package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.Domain.Entity.Interface.UserLesson;
import com.thigas.quack.Domain.Factory.Interface.UserLessonFactory;
import com.thigas.quack.UseCase.Boundary.UserLessonInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.UseCase.Mapper.UserLessonMapper;
import com.thigas.quack.UseCase.Model.Request.CompletedLessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
public class UserLessonService implements UserLessonInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(UserLessonService.class);
    
    private final UserLessonDsGateway userLessonDsGateway;
    private final UserLessonFactory userLessonFactory;
    private final UserLessonMapper userLessonMapper;

    @Override
    public ResponseWrapper<GenericResponseModel> completedLesson(CompletedLessonRequestModel request) {
        try {
            UserLesson userLesson = userLessonFactory.create(request.userId(), request.lessonId(), true);
            
            if (userLessonDsGateway.saveUserLesson(userLessonMapper.toDsModel(userLesson))) {
                return new ResponseWrapper<>(new GenericResponseModel("Lesson completed successfully"), 200);
            }
            
            return new ResponseWrapper<>(new GenericResponseModel("Error completing lesson"), 400);
        } catch (Exception e) {
            logger.error("Error completing lesson for user ID: {}", request.userId(), e);
            return new ResponseWrapper<>(new GenericResponseModel("Error completing lesson"), 500);
        }
    }

    @Override
    public ResponseWrapper<GenericResponseModel> getByUserIdAndLessonId(Integer userId, Integer lessonId) {
        try {
            Optional<UserLessonDataMapper> userLesson = userLessonDsGateway.getByUserIdAndLessonId(userId, lessonId);
            if (userLesson.isPresent()) {
                UserLessonRequestModel lessonResponse = new UserLessonRequestModel(
                        userLesson.get().getId(),
                        userLesson.get().getUser().getId(),
                        userLesson.get().getLesson().getId(),
                        userLesson.get().getCompleted()
                );
                
                return new ResponseWrapper<>(
                        new GenericResponseModel("Lesson found for the user", Map.of("lesson", lessonResponse)), 200
                );
            }
            return new ResponseWrapper<>(new GenericResponseModel("Lesson not found for the user", null), 404);
        } catch (Exception e) {
            logger.error("Error getting lesson by user ID: {} and lesson ID: {}", userId, lessonId, e);
            return new ResponseWrapper<>(new GenericResponseModel("Error getting lesson"), 500);
        }
    }

    public ResponseWrapper<GenericResponseModel> getById(Integer id) {
        try {
            Optional<UserLessonDataMapper> userLesson = userLessonDsGateway.getUserLessonById(id);
            if (userLesson.isPresent()) {
                UserLessonRequestModel lessonResponse = new UserLessonRequestModel(
                        userLesson.get().getId(),
                        userLesson.get().getUser().getId(),
                        userLesson.get().getLesson().getId(),
                        userLesson.get().getCompleted()
                );
                
                return new ResponseWrapper<>(
                        new GenericResponseModel("UserLesson found", Map.of("lesson", lessonResponse)), 200
                );
            }
            return new ResponseWrapper<>(new GenericResponseModel("UserLesson not found", null), 404);
        } catch (Exception e) {
            logger.error("Error getting user lesson by ID: {}", id, e);
            return new ResponseWrapper<>(new GenericResponseModel("Error getting user lesson"), 500);
        }
    }

    public ResponseWrapper<GenericResponseModel> getByUserId(Integer userId) {
        try {
            List<UserLessonDataMapper> userLessons = userLessonDsGateway.getByUserId(userId);
            if (!userLessons.isEmpty()) {
                List<UserLessonRequestModel> lessonResponses = userLessons.stream().map(ul -> new UserLessonRequestModel(
                        ul.getId(),
                        ul.getUser().getId(),
                        ul.getLesson().getId(),
                        ul.getCompleted()
                )).toList();
                
                return new ResponseWrapper<>(
                        new GenericResponseModel("UserLessons found for the user", Map.of("lessons", lessonResponses)), 200
                );
            }
            return new ResponseWrapper<>(new GenericResponseModel("UserLessons not found for the user", null), 404);
        } catch (Exception e) {
            logger.error("Error getting user lessons by user ID: {}", userId, e);
            return new ResponseWrapper<>(new GenericResponseModel("Error getting user lessons"), 500);
        }
    }
}