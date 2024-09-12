package com.thigas.quack.application.service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.repository.IAchievementRepository;

@Service
public class AchievementService {

    @Autowired
    private IAchievementRepository achievementRepository;

    private final AchievementMapper achievementMapper = AchievementMapper.INSTANCE;

    public AchievementDTO create(AchievementDTO achievementDTO) {
        // Converter DTO para entidade
        AchievementEntity achievement = achievementMapper.toAchievement(achievementDTO);
        // Salvar a entidade
        AchievementEntity toSaveAchievement = achievementRepository.save(achievement);
        // Converter entidade de volta para DTO
        return achievementMapper.toAchievementDTO(toSaveAchievement);
    }

    public Optional<AchievementDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<AchievementEntity> achievement = achievementRepository.findById(id);
        // Converter a entidade para DTO
        return achievement.map(achievementMapper::toAchievementDTO);
    }

    public Iterable<AchievementDTO> getAll() {
        // Buscar todas as entidades
        Iterable<AchievementEntity> achievements = achievementRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(achievements.spliterator(), false)
                .map(achievementMapper::toAchievementDTO)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        // Converter DTO para entidade
        AchievementEntity achievement = achievementMapper.toAchievement(achievementDTO);
        // Atualizar a entidade
        achievementRepository.save(achievement);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }
}