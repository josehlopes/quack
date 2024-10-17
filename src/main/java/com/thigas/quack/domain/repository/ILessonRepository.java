package com.thigas.quack.domain.repository;


import com.thigas.quack.infrastructure.persistence.entity.LessonModel;

import java.util.Optional;
import java.util.Set;

public interface ILessonRepository {
    LessonModel save(LessonModel lesson);

    Set<LessonModel> saveAll(Set<LessonModel> lessons);

    Optional<LessonModel> findById(int id);

    Boolean existsById(int id);

    Iterable<LessonModel> findAll();

    void deleteById(int id);
}
