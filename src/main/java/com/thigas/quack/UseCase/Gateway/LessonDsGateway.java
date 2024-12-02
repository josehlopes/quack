package com.thigas.quack.UseCase.Gateway;


import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;

import java.util.Optional;
import java.util.Set;

public interface LessonDsGateway {
    Optional<LessonRequestModel> getById(Integer id);

    boolean existsById(Integer id);

    Iterable<LessonRequestModel> getAll();
}
