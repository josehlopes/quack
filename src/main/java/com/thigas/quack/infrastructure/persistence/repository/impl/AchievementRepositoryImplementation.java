package com.thigas.quack.infrastructure.persistence.repository.impl;

import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.repository.jpa.IAchievementModelRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AchievementRepositoryImplementation implements IAchievementRepository {

    @Autowired
    private IAchievementModelRepository achievementModelRepository;

    @Override
    @Transactional
    public AchievementModel save(AchievementModel achievementModel) {
        return achievementModelRepository.save(achievementModel);
    }

    @Override
    @Transactional
    public Optional<AchievementModel> findById(int id) {
        return achievementModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<AchievementModel> findAll() {
        return achievementModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        achievementModelRepository.deleteById(id);
    }
}