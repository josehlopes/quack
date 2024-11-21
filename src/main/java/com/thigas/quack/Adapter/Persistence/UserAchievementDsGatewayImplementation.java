package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
import com.thigas.quack.Adapter.Repository.JpaUserAchievementRepository;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserAchievementDsGatewayImplementation implements UserAchievementDsGateway {

    private final JpaUserAchievementRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(UserAchievementRequestModel userAchievementDtoRequest) {
        UserAchievementDataMapper toSaveUserAchievement = mapper.mapUserAchievementDtoRequestToDataMapper(userAchievementDtoRequest);
        repository.save(toSaveUserAchievement);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<UserAchievementRequestModel> findById(int id) {
        Optional<UserAchievementDataMapper> userAchievement = repository.findById(id);
        return userAchievement.map(mapper::mapUserAchievementDataMapperToDtoRequest);
    }

    @Override
    public Iterable<UserAchievementRequestModel> findAll() {
        Iterable<UserAchievementDataMapper> userAchievements = repository.findAll();
        return StreamSupport.stream(userAchievements.spliterator(), false)
                .map(mapper::mapUserAchievementDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}