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
        // Converter DTO para entidade
        AchievementEntity achievement = achievementMapper.DtoToEntity(achievementDTO);
        // Salvar a entidade
        AchievementEntity toSaveAchievement = achievementRepository.save(achievement);
        // Converter entidade de volta para DTO
        return achievementMapper.EntityToDto(toSaveAchievement);
    }

    public Optional<AchievementDTO> getById(int id) {
        // Buscar a entidade do repositório
        Optional<AchievementEntity> achievement = achievementRepository.findById(id);
        // Converter a entidade para DTO
        return achievement.map(achievementMapper::EntityToDto);
    }

    public Iterable<AchievementDTO> getAll() {
        // Buscar todas as entidades
        Iterable<AchievementEntity> achievements = achievementRepository.findAll();
        // Converter todas as entidades para DTOs
        return StreamSupport.stream(achievements.spliterator(), false)
                .map(achievementMapper::EntityToDto)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        // Converter DTO para entidade
        AchievementEntity achievement = achievementMapper.DtoToEntity(achievementDTO);
        // Atualizar a entidade
        achievementRepository.save(achievement);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }
}