package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;

import java.util.Optional;
import java.util.Set;

public interface LessonDsGateway {
    void save(LessonRequestModel lesson);

    Set<LessonRequestModel> saveAll(Set<LessonRequestModel> lessons);

    Optional<LessonRequestModel> findById(int id);

    boolean existsById(int id);

    Iterable<LessonRequestModel> findAll();

    void deleteById(int id);
}
