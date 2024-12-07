package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.CompletedLessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface UserLessonInputBoundary {
    ResponseWrapper<GenericResponseModel> completedLesson(CompletedLessonRequestModel request);

    ResponseWrapper<GenericResponseModel> findByUserIdAndLessonId(Integer userId, Integer lessonId);

    ResponseWrapper<GenericResponseModel> findById(Integer id);

    ResponseWrapper<GenericResponseModel> findByUserId(Integer userId);
}
