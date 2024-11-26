package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor

public class UserAchievementService {

    private UserAchievementDsGateway userAchievementDsGateway;

    private AchievementService achievementService;

    private UserService userService;

    public void create(UserAchievementRequestModel userAchievementDTO) {
        userAchievementDsGateway.save(userAchievementDTO);
    }

    public Optional<UserAchievementRequestModel> getById(int id) {
        return userAchievementDsGateway.findById(id);
    }

    public Iterable<UserAchievementRequestModel> getAll() {
        Iterable<UserAchievementRequestModel> userAchievements = userAchievementDsGateway.findAll();
        return StreamSupport.stream(userAchievements.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserAchievementRequestModel userAchievementDTO) {
        UserAchievementRequestModel existingUserAchievement = userAchievementDsGateway.findById(userAchievementDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementRequestModel updatedEntity = new UserAchievementRequestModel(
                userAchievementDTO.id(),
                userAchievementDTO.userId() != null ? userAchievementDTO.userId() : existingUserAchievement.userId(),
                userAchievementDTO.achievementId() != null ? userAchievementDTO.achievementId() : existingUserAchievement.achievementId(),
                userAchievementDTO.imagePath() != null ? userAchievementDTO.imagePath() : existingUserAchievement.imagePath(),
                userAchievementDTO.obtainedDate() != null ? userAchievementDTO.obtainedDate() : existingUserAchievement.obtainedDate(),
                userAchievementDTO.status() != null ? userAchievementDTO.status() : existingUserAchievement.status()
        );

        userAchievementDsGateway.save(updatedEntity);
    }

    public void delete(int id) {
        userAchievementDsGateway.deleteById(id);
    }

//    public Boolean unlockAchievement(int userId, int achievementId) {
//        if (!userService.existsById(userId) || !achievementService.existsById(achievementId)) {
//            return false;
//        }
//
//        UserDsRequestModel user = userService.getById(userId).orElse(null);
//        AchievementRequestModel achievement = achievementService.getById(achievementId).orElse(null);
//
//        if (user == null || achievement == null) {
//            return false;
//        }
//
//        UserAchievementRequestModel userAchievementDtoRequestModel = new UserAchievementRequestModel(
//                null, user.id(), achievement.id(), null, OffsetDateTime.now().toString(), Status.UNLOCKED.getValue()
//        );
//
//        userAchievementDsGateway.save(userAchievementDtoRequestModel);
//
//        return true;
//    }

    public Boolean markAchievementAsCompleted(int id) {
        UserAchievementRequestModel existingUserAchievement = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementRequestModel userAchievementRequestModel = new UserAchievementRequestModel(
                existingUserAchievement.id(),
                existingUserAchievement.userId(),
                existingUserAchievement.achievementId(),
                existingUserAchievement.imagePath(),
                OffsetDateTime.now().toString(),
                Status.FINISHED.getValue()
        );

        userAchievementDsGateway.save(userAchievementRequestModel);
        return true;
    }
}