package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;

import java.util.Optional;

public interface UserLessonDsGateway {
    void save(UserLessonRequestModel userLesson);

    Optional<UserLessonRequestModel> findById(int id);

    Iterable<UserLessonRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
