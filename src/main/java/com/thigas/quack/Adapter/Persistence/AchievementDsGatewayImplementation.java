package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.Adapter.Repository.AchievementRepository;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.AchievementMapper;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class AchievementDsGatewayImplementation implements AchievementDsGateway {

    private final AchievementRepository repository;
    private final AchievementMapper mapper;

    @Override
    public Optional<AchievementRequestModel> getAchievementById(Integer id) {
        Optional<AchievementDataMapper> achievement = repository.getById(id);
        return achievement.map(mapper::toDsModel);
    }

    @Override
    public Iterable<AchievementRequestModel> getAllAchievements() {
        Iterable<AchievementDataMapper> achievements = repository.getAll();

        return StreamSupport.stream(achievements.spliterator(), false)
                .map(mapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}