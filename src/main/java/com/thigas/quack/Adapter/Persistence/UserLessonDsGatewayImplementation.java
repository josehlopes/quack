package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.Adapter.Repository.JpaUserLessonRepository;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.User.UserLessonDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserLessonDsGatewayImplementation implements UserLessonDsGateway {

    private final JpaUserLessonRepository repository;
    private final MapStructMapper mapper;

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