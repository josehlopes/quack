package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.repository.IAchievementRepository;
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
        AchievementEntity achievement = achievementMapper.dtoToEntity(achievementDTO);
        AchievementEntity toSaveAchievement = achievementRepository.save(achievement);
        return achievementMapper.entityToDto(toSaveAchievement);
    }

    public Optional<AchievementDTO> getById(int id) {
        Optional<AchievementEntity> achievement = achievementRepository.findById(id);
        return achievement.map(achievementMapper::entityToDto);
    }

    public Iterable<AchievementDTO> getAll() {
        Iterable<AchievementEntity> achievements = achievementRepository.findAll();
        return StreamSupport.stream(achievements.spliterator(), false).map(achievementMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        AchievementEntity achievement = achievementMapper.dtoToEntity(achievementDTO);
        achievementRepository.save(achievement);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }
}