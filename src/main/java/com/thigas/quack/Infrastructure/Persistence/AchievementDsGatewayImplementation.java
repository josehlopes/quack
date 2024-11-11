package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Adapter.Mapper.MapStructMapper;
import com.thigas.quack.Infrastructure.Entity.AchievementDataMapper;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaAchievementRepository;
import com.thigas.quack.UseCase.Model.Request.AchievementDtoRequestModel;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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