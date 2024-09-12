package com.thigas.quack.domain.repository;

import java.util.Optional;

import com.thigas.quack.domain.entity.LessonEntity;

public interface ILessonRepository {
    LessonEntity save(LessonEntity lesson);

    Optional<LessonEntity> findById(int id);

    Iterable<LessonEntity> findAll();

    void deleteById(int id);
}
