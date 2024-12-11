package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.LessonDataMapper;
import com.thigas.quack.Adapter.Repository.LessonRepository;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.UseCase.Mapper.LessonMapper;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;


import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class LessonDsGatewayImplementation implements LessonDsGateway {

    private final LessonRepository repository;
    private final LessonMapper mapper;


    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<LessonRequestModel> getLessonById(Integer id) {
        Optional<LessonDataMapper> lesson = repository.getById(id);
        return lesson.map(mapper::toDsModel);
    }

    @Override
    public Set<LessonRequestModel> getAllLessons() {
        Iterable<LessonDataMapper> lessonDataMappers = repository.getAll();

        return StreamSupport.stream(lessonDataMappers.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toSet());
    }

}