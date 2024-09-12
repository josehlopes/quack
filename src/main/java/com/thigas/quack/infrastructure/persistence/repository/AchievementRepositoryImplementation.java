package com.thigas.quack.infrastructure.persistence.repository;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

@Repository
public class AchievementRepositoryImplementation implements IAchievementRepository {

    @Autowired
    private IAchievementModelRepository achievementModelRepository;

    private final AchievementMapper achievementMapper = AchievementMapper.INSTANCE;

    @Override
    public AchievementEntity save(AchievementEntity achievement) {
        AchievementModel achievementModel = achievementMapper.toAchievementModel(achievement);
        AchievementModel savedAchievementModel = achievementModelRepository.save(achievementModel);
        return achievementMapper.toAchievement(savedAchievementModel);
    }

    @Override
    public Optional<AchievementEntity> findById(Long id) {
        return achievementModelRepository.findById(id).map(achievementMapper::toAchievement);
    }

    @Override
    public Iterable<AchievementEntity> findAll() {
        return achievementModelRepository.findAll().stream()
                .map(achievementMapper::toAchievement)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        achievementModelRepository.deleteById(id);
    }
}