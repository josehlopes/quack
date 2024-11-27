package com.thigas.quack.Adapter.Persistence;

import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
import com.thigas.quack.Adapter.Repository.UserAchievementRepository;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Mapper.AchievementMapper;
import com.thigas.quack.UseCase.Mapper.UserAchievementMapper;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementUnlockRequestModel;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserAchievementDsGatewayImplementation implements UserAchievementDsGateway {

    private final UserAchievementRepository repository;
    private final UserAchievementMapper mapper;
    private final AchievementMapper achievementMapper;

    @Override
    public Optional<UserAchievementRequestModel> getUserAchievementById(Integer id) {
        Optional<UserAchievementDataMapper> userAchievement = repository.getById(id);
        return userAchievement.map(mapper::toDsModel);
    }

    @Override
    public Boolean findByUserIdAndAchievementId(Integer userId, Integer achievementId) {
//        return repository.existsByUserIdAndAchievementId(userId, achievementId);
        return true;
    }

    @Override
    public Iterable<AchievementRequestModel> getAllUserAchievements(Integer userId) {
        return StreamSupport.stream(repository.getAllUserAchievements(userId).spliterator(), false)
                .map(achievementMapper::toDsModel)
                .collect(Collectors.toList());
    }

    @Override
    public void lockUserAchievement(Integer userAchievementId) {
        Optional<UserAchievementDataMapper> userAchievement = repository.getById(userAchievementId);
        userAchievement.ifPresent(achievement -> {
            achievement.setIsActive(false);
            repository.save(achievement);
        });
    }

    @Override
    public void save(UserAchievementRequestModel dataSourceModel) {
        UserAchievementDataMapper userAchievementDataMapper = mapper.toDataMapper(dataSourceModel);
        repository.save(userAchievementDataMapper);
    }

    @Override
    public void unlockUserAchievement(UserAchievementUnlockRequestModel userAchievementUnlockRequestModel) {
        Optional<UserAchievementDataMapper> userAchievement = repository.getById(userAchievementUnlockRequestModel.userId());
        userAchievement.ifPresent(achievement -> {
            achievement.setIsActive(true);
            repository.save(achievement);
        });
    }

    @Override
    public void deleteUserAchievementById(Integer id) {
        repository.deleteById(id);
    }
}