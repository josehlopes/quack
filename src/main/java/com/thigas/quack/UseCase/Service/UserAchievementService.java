package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserAchievementDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Model.Request.AchievementDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.Infrastructure.Model.UserAchievementDataMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserAchievementService {

    @Autowired
    private UserAchievementDsGateway userAchievementRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    @Autowired
    private AchievementService achievementService;

    @Autowired
    private UserService userService;

    public void create(UserAchievementDTO userAchievementDTO) {
        UserAchievementDsRequestModel userAchievementDsRequestModel = objectMapperService.toEntity(userAchievementDTO);
        UserAchievementDataMapper savedUserAchievement = userAchievementRepository.save(objectMapperService.toModel(userAchievementDsRequestModel));
    }

    public Optional<UserAchievementDTO> getById(int id) {
        return userAchievementRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserAchievementDTO> getAll() {
        Iterable<UserAchievementDataMapper> userAchievements = userAchievementRepository.findAll();
        return StreamSupport.stream(userAchievements.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(UserAchievementDTO userAchievementDTO) {
        UserAchievementDataMapper existingUserAchievement = userAchievementRepository.findById(userAchievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementDsRequestModel updatedEntity = objectMapperService.toEntity(userAchievementDTO);
        UserAchievementDataMapper updatedModel = objectMapperService.toModel(updatedEntity);

        userAchievementRepository.save(updatedModel);
    }

    public void delete(int id) {
        userAchievementRepository.deleteById(id);
    }

    public Boolean unlockAchievement(int userId, int achievementId) {
        if (!userService.existsById(userId) || !achievementService.existsById(achievementId)) {
            return false;
        }

        UserDsRequestModel user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
        AchievementDsRequestModel achievement = objectMapperService.toEntity(achievementService.getById(achievementId).orElse(null));

        if (user == null || achievement == null) {
            return false;
        }

        UserAchievementDsRequestModel userAchievementDsRequestModel = new UserAchievementDsRequestModel();
        userAchievementDsRequestModel.setUser(user);
        userAchievementDsRequestModel.setAchievement(achievement);
        userAchievementDsRequestModel.setObtainedDate(OffsetDateTime.from(LocalDate.now()));
        userAchievementDsRequestModel.setStatus(Status.UNLOCKED);

        UserAchievementDataMapper userAchievementDataMapper = objectMapperService.toModel(userAchievementDsRequestModel);
        userAchievementRepository.save(userAchievementDataMapper);

        return true;
    }

    public Boolean markAchievementAsCompleted(int id) {
        UserAchievementDTO existingUserAchievement = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementDsRequestModel userAchievementDsRequestModel = objectMapperService.toEntity(existingUserAchievement);

        userAchievementDsRequestModel.setStatus(Status.FINISHED);
        userAchievementDsRequestModel.setObtainedDate(OffsetDateTime.from(LocalDate.now()));

        UserAchievementDataMapper updatedModel = objectMapperService.toModel(userAchievementDsRequestModel);
        userAchievementRepository.save(updatedModel);
        return true;
    }
}