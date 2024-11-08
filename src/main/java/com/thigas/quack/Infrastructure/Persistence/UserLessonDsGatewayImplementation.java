package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.UserLessonDataMapper;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserLessonRepository;
import com.thigas.quack.UseCase.Model.Request.UserLessonDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserLessonDsGatewayImplementation implements UserLessonDsGateway {

    final JpaUserLessonRepository repository;
    private final MapStructMapper mapper;

    public UserLessonDsGatewayImplementation(JpaUserLessonRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(UserLessonDtoRequestModel userLessonDtoRequest) {
        UserLessonDataMapper toSaveUserLesson = mapper.mapUserLessonDtoRequestToDataMapper(userLessonDtoRequest);
        repository.save(toSaveUserLesson);
    }

    @Override
    public Optional<UserLessonDtoRequestModel> findById(int id) {
        Optional<UserLessonDataMapper> userLesson = repository.findById(id);
        return userLesson.map(mapper::mapUserLessonDataMapperToDtoRequest);
    }

    @Override
    public List<UserLessonDtoRequestModel> findAll() {
        List<UserLessonDataMapper> userLessons = repository.findAll();
        return userLessons.stream()
                .map(mapper::mapUserLessonDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}