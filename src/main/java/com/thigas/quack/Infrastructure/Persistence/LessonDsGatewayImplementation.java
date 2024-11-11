package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.LessonDataMapper;
import com.thigas.quack.UseCase.Gateway.LessonDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaLessonRepository;
import com.thigas.quack.UseCase.Model.Request.LessonDtoRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LessonDsGatewayImplementation implements LessonDsGateway {

    private final JpaLessonRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(LessonDtoRequestModel lessonDtoRequest) {
        LessonDataMapper toSaveLesson = mapper.mapLessonDtoRequestToDataMapper(lessonDtoRequest);
        repository.save(toSaveLesson);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Set<LessonDtoRequestModel> saveAll(Set<LessonDtoRequestModel> lessons) {
        Set<LessonDataMapper> lessonDataMappers = lessons.stream()
                .map(mapper::mapLessonDtoRequestToDataMapper)
                .collect(Collectors.toSet());
        List<LessonDataMapper> savedLessonDataMappers = repository.saveAll(lessonDataMappers);
        return savedLessonDataMappers.stream()
                .map(mapper::mapLessonDataMapperToDtoRequest)
                .collect(Collectors.toSet());
    }

    @Override
    public Optional<LessonDtoRequestModel> findById(int id) {
        Optional<LessonDataMapper> lesson = repository.findById(id);
        return lesson.map(mapper::mapLessonDataMapperToDtoRequest);
    }

    @Override
    public Set<LessonDtoRequestModel> findAll() {
        List<LessonDataMapper> lessonDataMappers = repository.findAll();
        return lessonDataMappers.stream()
                .map(mapper::mapLessonDataMapperToDtoRequest)
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}