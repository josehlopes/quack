package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;

import java.util.List;
import java.util.Optional;

public interface UserLessonDsGateway {

    Boolean save(UserLessonRequestModel dataSourceModel);

    void completedLesson(Integer userId, Integer lessonId, Boolean completed);

    Optional<UserLessonDataMapper> findByUserIdAndLessonId(Integer userId, Integer lessonId);

    Optional<UserLessonDataMapper> findById(Integer id);

    List<UserLessonDataMapper> findByUserId(Integer userId);

    void deleteUserLessonById(Integer userLessonId);
}
