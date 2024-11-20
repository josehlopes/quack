package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.User.UserLessonDtoRequestModel;

import java.util.Optional;

public interface UserLessonDsGateway {
    void save(UserLessonDtoRequestModel userLesson);

    Optional<UserLessonDtoRequestModel> findById(int id);

    Iterable<UserLessonDtoRequestModel> findAll();

    boolean existsById(int id);

    void deleteById(int id);
}
