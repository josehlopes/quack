package com.thigas.quack.UseCase.Gateway;

import com.thigas.quack.Infrastructure.Model.UserLessonDataMapper;

import java.util.Optional;

public interface UserLessonDsGateway {
    void save(UserLessonDataMapper userLesson);
    Optional<UserLessonDataMapper> findById(int id);
    Iterable<UserLessonDataMapper> findAll();
    boolean existsById(int id);
    void deleteById(int id);
}
