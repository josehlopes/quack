package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.Infrastructure.Model.AchievementDataMapper;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import com.thigas.quack.Infrastructure.Repository.JpaAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class AchievementDsGatewayImplementation implements AchievementDsGateway {

    @Autowired
    private JpaAchievementRepository achievementModelRepository;

    @Override
    public void save(AchievementDataMapper achievementDataMapper) {
        achievementModelRepository.save(achievementDataMapper);
    }

    @Override
    public Optional<AchievementDataMapper> findById(int id) {
        return achievementModelRepository.findById(id);
    }

    @Override
    public Iterable<AchievementDataMapper> findAll() {
        return achievementModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        achievementModelRepository.deleteById(id);
    }

    @Override
    public Boolean existsById(int id) {
        return achievementModelRepository.existsById(id);
    }
}