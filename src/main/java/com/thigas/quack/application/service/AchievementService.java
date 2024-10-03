package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.adapter.mapper.AchievementMapper;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.IAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
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
    private AchievementMapper achievementMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    public AchievementDTO create(AchievementDTO achievementDTO) {
        AchievementModel achievementModel = achievementMapper.dtoToModel(achievementDTO, context);
        AchievementModel savedAchievement = achievementRepository.save(achievementModel);
        return achievementMapper.modelToDto(savedAchievement, context);
    }

    public Optional<AchievementDTO> getById(int id) {
        Optional<AchievementModel> achievementOptional = achievementRepository.findById(id);
        return achievementOptional.map(achievement -> achievementMapper.modelToDto(achievement, new CycleAvoidingMappingContext()));
    }

    public Iterable<AchievementDTO> getAll() {
        Iterable<AchievementModel> achievements = achievementRepository.findAll();
        CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();
        return StreamSupport.stream(achievements.spliterator(), false)
                .map(achievement -> achievementMapper.modelToDto(achievement, context))
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        AchievementModel existingUser = achievementRepository.findById(achievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        achievementRepository.save(existingUser);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }

}