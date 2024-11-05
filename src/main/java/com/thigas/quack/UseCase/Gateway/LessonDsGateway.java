package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.Infrastructure.Entity.LessonDataMapper;

import java.util.Optional;
import java.util.Set;

public interface LessonDsGateway {
    void save(LessonDataMapper lesson);
    Set<LessonDataMapper> saveAll(Set<LessonDataMapper> lessons);
    Optional<LessonDataMapper> findById(int id);
    boolean existsById(int id);
    Iterable<LessonDataMapper> findAll();
    void deleteById(int id);
}
