package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.LessonEntity;

import java.util.Optional;
import java.util.Set;

public interface ILessonRepository {
    LessonEntity save(LessonEntity lesson);

    Set<LessonEntity> saveAll(Set<LessonEntity> lessons);

    Optional<LessonEntity> findById(int id);

    Iterable<LessonEntity> findAll();

    void deleteById(int id);
}
