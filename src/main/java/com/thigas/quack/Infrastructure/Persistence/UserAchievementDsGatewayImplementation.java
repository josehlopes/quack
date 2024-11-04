package com.thigas.quack.Infrastructure.Persistence;

import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.Infrastructure.Model.UserAchievementDataMapper;
import com.thigas.quack.Infrastructure.Repository.JpaUserAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserAchievementDsGatewayImplementation implements UserAchievementDsGateway {


    @Autowired
    private JpaUserAchievementRepository userAchievementModelRepository;

    @Override
    public UserAchievementDataMapper save(UserAchievementDataMapper userAchievementDataMapper) {
        userAchievementModelRepository.save(userAchievementDataMapper);
        return userAchievementDataMapper;
    }

    @Override
    public boolean existsById(int id) {
        return userAchievementModelRepository.existsById(id);
    }

    @Override
    public Optional<UserAchievementDataMapper> findById(int id) {
        return userAchievementModelRepository.findById(id);
    }

    @Override
    public Iterable<UserAchievementDataMapper> findAll() {
        return userAchievementModelRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        userAchievementModelRepository.deleteById(id);
    }
}
