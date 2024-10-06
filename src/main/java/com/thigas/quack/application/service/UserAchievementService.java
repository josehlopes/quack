package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.domain.repository.IUserAchievementRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserAchievementService {

    @Autowired
    private IUserAchievementRepository userAchievementRepository;

    @Autowired
    private ObjectMapperService objectMapperService; // Usar ObjectMapperService

    public UserAchievementDTO create(UserAchievementDTO userAchievementDTO) {
        UserAchievementModel userAchievementModel = objectMapperService.toModel(userAchievementDTO); // Usando ObjectMapperService
        UserAchievementModel savedUserModel = userAchievementRepository.save(userAchievementModel);
        return objectMapperService.toDto(savedUserModel); // Usando ObjectMapperService
    }

    public Optional<UserAchievementDTO> getById(int id) {
        return userAchievementRepository.findById(id)
                .map(objectMapperService::toDto); // Usando ObjectMapperService
    }

    public Iterable<UserAchievementDTO> getAll() {
        Iterable<UserAchievementModel> userAchievements = userAchievementRepository.findAll();
        return StreamSupport.stream(userAchievements.spliterator(), false)
                .map(objectMapperService::toDto) // Usando ObjectMapperService
                .collect(Collectors.toList());
    }

    public void update(UserAchievementDTO userAchievementDTO) {
        UserAchievementModel existingUserAchievement = userAchievementRepository.findById(userAchievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("UserAchievement not found"));

        existingUserAchievement.setId(userAchievementDTO.getId());

        userAchievementRepository.save(existingUserAchievement);
    }

    public void delete(int id) {
        if (!userAchievementRepository.existsById(id)) {
            throw new IllegalArgumentException("UserAchievement não encontrado com id: " + id);
        }
        userAchievementRepository.deleteById(id);
    }
}
