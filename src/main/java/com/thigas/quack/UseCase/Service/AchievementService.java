package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.AchievementDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.Infrastructure.Model.AchievementDataMapper;
import com.thigas.quack.UseCase.Gateway.AchievementDsGateway;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AchievementService {

    @Autowired
    private AchievementDsGateway achievementRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    public void create(AchievementDTO achievementDTO) {
        AchievementDataMapper achievementDataMapper = objectMapperService.toModel(achievementDTO);
        achievementRepository.save(achievementDataMapper);
    }

    public Optional<AchievementDTO> getById(int id) {
        Optional<AchievementDataMapper> achievement = achievementRepository.findById(id);
        return achievement.map(objectMapperService::toDto);
    }

    public Iterable<AchievementDTO> getAll() {
        Iterable<AchievementDataMapper> achievements = achievementRepository.findAll();
        return StreamSupport.stream(achievements.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(AchievementDTO achievementDTO) {
        AchievementDataMapper existingAchievement = achievementRepository.findById(achievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Achievement not found"));
        AchievementDataMapper updatedAchievement = objectMapperService.toModel(achievementDTO);
        achievementRepository.save(updatedAchievement);
    }

    public void delete(int id) {
        achievementRepository.deleteById(id);
    }

    public Boolean existsById(int achievementId) {
        return achievementRepository.existsById(achievementId);
    }

}
