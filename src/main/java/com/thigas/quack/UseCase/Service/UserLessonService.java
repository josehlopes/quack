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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class UserLessonService implements UserLessonInputBoundary {

    private final UserLessonDsGateway userLessonDsGateway;
    private final UserLessonFactory userLessonFactory;
    private final UserLessonMapper userLessonMapper;

    @Override
    public ResponseWrapper<GenericResponseModel> completedLesson(CompletedLessonRequestModel request) {
        UserLesson userLesson = userLessonFactory.create(request.userId(), request.lessonId());
        userLesson.setCompleted(request.completed());

        if (userLessonDsGateway.save(userLessonMapper.toDsModel(userLesson))) {
            return new ResponseWrapper<>(new GenericResponseModel("Lesson completed successfully"), 200);
        }

        return new ResponseWrapper<>(new GenericResponseModel("Error completing lesson"), 400);
    }

    @Override
    public ResponseWrapper<GenericResponseModel> findByUserIdAndLessonId(Integer userId, Integer lessonId) {
        Optional<UserLessonDataMapper> userLesson = userLessonDsGateway.findByUserIdAndLessonId(userId, lessonId);
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
    }

    public ResponseWrapper<GenericResponseModel> findById(Integer id) {
        Optional<UserLessonDataMapper> userLesson = userLessonDsGateway.findById(id);
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
    }

    public ResponseWrapper<GenericResponseModel> findByUserId(Integer userId) {
        List<UserLessonDataMapper> userLessons = userLessonDsGateway.findByUserId(userId);
        if (!userLessons.isEmpty()) {
            List<UserLessonRequestModel> lessonResponses = userLessons.stream().map(ul -> new UserLessonRequestModel(
                    ul.getId(),
                    ul.getUser().getId(),
                    ul.getLesson().getId(),
                    ul.getCompleted()
            )).collect(Collectors.toList());

            return new ResponseWrapper<>(
                    new GenericResponseModel("UserLessons found for the user", Map.of("lessons", lessonResponses)), 200
            );
        }
        return new ResponseWrapper<>(new GenericResponseModel("UserLessons not found for the user", null), 404);
    }


}
