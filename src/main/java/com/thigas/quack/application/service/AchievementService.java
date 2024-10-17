package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AchievementService {

    @Autowired
    private IAchievementRepository achievementRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public AchievementDTO create(AchievementDTO achievementDTO) {
        AchievementModel achievementModel = objectMapperService.toModel(achievementDTO);
        AchievementModel savedAchievement = achievementRepository.save(achievementModel);
        return objectMapperService.toDto(savedAchievement);
    }

    public Optional<AchievementDTO> getById(int id) {
        Optional<AchievementModel> achievement = achievementRepository.findById(id);
        return achievement.map(objectMapperService::toDto);
    }

    public Iterable<AchievementDTO> getAll() {
        Iterable<AchievementModel> achievements = achievementRepository.findAll();
        return StreamSupport.stream(achievements.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        AchievementModel existingAchievement = achievementRepository.findById(achievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Achievement not found"));
        AchievementModel updatedAchievement = objectMapperService.toModel(achievementDTO);
        achievementRepository.save(updatedAchievement);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }
}
