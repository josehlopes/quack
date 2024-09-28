package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AchievementService {

    private final AchievementMapper achievementMapper = AchievementMapper.INSTANCE;

    @Autowired
    private IAchievementRepository achievementRepository;

    public AchievementDTO create(AchievementDTO achievementDTO) {
        AchievementModel achievementModel = achievementMapper.dtoToModel(achievementDTO);
        AchievementModel toSaveAchievement = achievementRepository.save(achievementModel);
        return achievementMapper.modelToDto(toSaveAchievement);
    }

    public Optional<AchievementDTO> getById(int id) {
        Optional<AchievementModel> achievementModel = achievementRepository.findById(id);
        return achievementModel.map(achievementMapper::modelToDto);
    }

    public Iterable<AchievementDTO> getAll() {
        Iterable<AchievementModel> achievements = achievementRepository.findAll();
        return StreamSupport.stream(achievements.spliterator(), false).map(achievementMapper::modelToDto)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        AchievementModel achievementModel = achievementMapper.dtoToModel(achievementDTO);
        achievementRepository.save(achievementModel);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }
}