package com.thigas.quack.infrastructure.persistence.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IAchievementModelRepository;

@Repository
public class AchievementRepositoryImplementation implements IAchievementRepository {

    @Autowired
    private IAchievementModelRepository achievementModelRepository;

    private final AchievementMapper achievementMapper = AchievementMapper.INSTANCE;

    @Override
    public AchievementEntity save(AchievementEntity achievement) {
        AchievementModel achievementModel = achievementMapper.EntityToModel(achievement);
        AchievementModel savedAchievementModel = achievementModelRepository.save(achievementModel);
        return achievementMapper.ModelToEntity(savedAchievementModel);
    }

    @Override
    public Optional<AchievementEntity> findById(int id) {
        return achievementModelRepository.findById(id).map(achievementMapper::ModelToEntity);
    }

    @Override
    public Iterable<AchievementEntity> findAll() {
        return achievementModelRepository.findAll().stream()
                .map(achievementMapper::ModelToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(int id) {
        achievementModelRepository.deleteById(id);
    }
}