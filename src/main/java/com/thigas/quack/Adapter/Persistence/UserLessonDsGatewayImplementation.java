package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.Adapter.Repository.UserLessonRepository;
import com.thigas.quack.UseCase.Gateway.UserLessonDsGateway;
import com.thigas.quack.UseCase.Mapper.UserLessonMapper;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserLessonDsGatewayImplementation implements UserLessonDsGateway {

    private final UserLessonRepository repository;
    private final UserLessonMapper mapper;

    @Override
    public Boolean saveUserLesson(UserLessonRequestModel userLessonRequestModel) {
        UserLessonDataMapper toSaveUserRoadmap = mapper.toDataMapper(userLessonRequestModel);
        return repository.save(toSaveUserRoadmap);
    }


    @Override
    public void completeLesson(Integer userId, Integer lessonId, Boolean completed) {
        Optional<UserLessonDataMapper> userLesson = repository.findByUserIdAndLessonId(userId, lessonId);
        userLesson.ifPresent(lesson -> {
            lesson.setCompleted(completed);
            repository.update(lesson);
        });
    }

    @Override
    public Optional<UserLessonDataMapper> getByUserIdAndLessonId(Integer userId, Integer lessonId) {
        return repository.findByUserIdAndLessonId(userId, lessonId);
    }

    @Override
    public Optional<UserLessonDataMapper> getUserLessonById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<UserLessonDataMapper> getByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public void deleteUserLessonById(Integer userLessonId) {
        if (repository.existsById(userLessonId)) {
            repository.deleteById(userLessonId);
        }
    }
}
