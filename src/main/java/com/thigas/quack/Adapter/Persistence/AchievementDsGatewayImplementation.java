package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.Adapter.Repository.JpaAchievementRepository;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.MapStructMapper;
import com.thigas.quack.UseCase.Model.Request.Address.AchievementDtoRequestModel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class AchievementDsGatewayImplementation implements AchievementDsGateway {

    private final JpaAchievementRepository repository;
    private final MapStructMapper mapper;

    @Override
    public void save(AchievementDtoRequestModel achievementDtoRequest) {
        AchievementDataMapper toSaveAchievement = mapper.mapAchievementDtoRequestToDataMapper(achievementDtoRequest);
        repository.save(toSaveAchievement);
    }

    @Override
    public Optional<AchievementDtoRequestModel> findById(int id) {
        Optional<AchievementDataMapper> achievement = repository.findById(id);
        return achievement.map(mapper::mapAchievementDataMapperToDtoRequest);
    }

    @Override
    public Iterable<AchievementDtoRequestModel> findAll() {
        Iterable<AchievementDataMapper> achievements = repository.findAll();

        return StreamSupport.stream(achievements.spliterator(), false)
                .map(mapper::mapAchievementDataMapperToDtoRequest)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return repository.existsById(id);
    }
}