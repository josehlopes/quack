package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;

import java.util.Optional;

public interface LessonDsGateway {
    Optional<LessonRequestModel> getLessonById(Integer id);

    Boolean existsById(Integer id);

    Iterable<LessonRequestModel> getAllLessons();
}
