package com.thigas.quack.domain.repository;

import com.thigas.quack.domain.entity.Lesson;

import java.util.Optional;

public interface ILessonRepository {
    Lesson save(Lesson lesson);

    Optional<Lesson> findById(Long id);

    Iterable<Lesson> findAll();

    void deleteById(Long id);
}
