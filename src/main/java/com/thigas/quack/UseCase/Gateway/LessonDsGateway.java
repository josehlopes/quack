package com.thigas.quack.UseCase.Gateway;



import com.thigas.quack.UseCase.Model.Request.LessonDtoRequestModel;

import java.util.Optional;
import java.util.Set;

public interface LessonDsGateway {
    void save(LessonDtoRequestModel lesson);
    Set<LessonDtoRequestModel> saveAll(Set<LessonDtoRequestModel> lessons);
    Optional<LessonDtoRequestModel> findById(int id);
    boolean existsById(int id);
    Iterable<LessonDtoRequestModel> findAll();
    void deleteById(int id);
}
