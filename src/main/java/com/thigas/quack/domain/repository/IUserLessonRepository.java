package com.thigas.quack.domain.repository;

import com.thigas.quack.infrastructure.persistence.entity.UserLessonModel;

import java.util.Optional;

public interface IUserLessonRepository {
    UserLessonModel save(UserLessonModel userLesson);

    Optional<UserLessonModel> findById(int id);

    Iterable<UserLessonModel> findAll();

    Boolean existsById(int id);

    void deleteById(int id);
}
