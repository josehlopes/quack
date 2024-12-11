package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserLessonDsGateway {

    Boolean saveUserLesson(UserLessonRequestModel dataSourceModel);

    void completeLesson(Integer userId, Integer lessonId, Boolean completed);

    Optional<UserLessonDataMapper> getByUserIdAndLessonId(Integer userId, Integer lessonId);

    Optional<UserLessonDataMapper> getUserLessonById(Integer id);

    List<UserLessonDataMapper> getByUserId(Integer userId);

    void deleteUserLessonById(Integer userLessonId);
}
