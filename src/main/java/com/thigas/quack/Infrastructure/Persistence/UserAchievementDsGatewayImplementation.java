package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.UserAchievementDataMapper;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaUserAchievementRepository;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDtoRequestModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class UserAchievementDsGatewayImplementation implements UserAchievementDsGateway {

    final JpaUserAchievementRepository repository;
    private final MapStructMapper mapper;

    public UserAchievementDsGatewayImplementation(JpaUserAchievementRepository repository, MapStructMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void save(UserAchievementDtoRequestModel userAchievementDtoRequest) {
        UserAchievementDataMapper toSaveUserAchievement = mapper.mapUserAchievementDtoRequestToDataMapper(userAchievementDtoRequest);
        repository.save(toSaveUserAchievement);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<UserAchievementDtoRequestModel> findById(int id) {
        Optional<UserAchievementDataMapper> userAchievement = repository.findById(id);
        return userAchievement.map(mapper::mapUserAchievementDataMapperToDtoRequest);
    }

    @Override
    public Iterable<UserAchievementDtoRequestModel> findAll() {
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