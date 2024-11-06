package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserAchievementDsGateway;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserAchievementService {

    @Autowired
    private UserAchievementDsGateway userAchievementDsGateway;


    @Autowired
    private AchievementService achievementService;

    @Autowired
    private UserService userService;

    public void create(UserAchievementDtoRequestModel userAchievementDTO) {
        userAchievementDsGateway.save(userAchievementDTO);
    }

    public Optional<UserAchievementDtoRequestModel> getById(int id) {
        return userAchievementDsGateway.findById(id);
    }

    public Iterable<UserAchievementDtoRequestModel> getAll() {
        Iterable<UserAchievementDtoRequestModel> userAchievements = userAchievementDsGateway.findAll();
        return StreamSupport.stream(userAchievements.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserAchievementDtoRequestModel userAchievementDTO) {
        UserAchievementDtoRequestModel existingUserAchievement = userAchievementDsGateway.findById(userAchievementDTO.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementDtoRequestModel updatedEntity = new UserAchievementDtoRequestModel(
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
//        UserDtoRequestModel user = userService.getById(userId).orElse(null);
//        AchievementDtoRequestModel achievement = achievementService.getById(achievementId).orElse(null);
//
//        if (user == null || achievement == null) {
//            return false;
//        }
//
//        UserAchievementDtoRequestModel userAchievementDtoRequestModel = new UserAchievementDtoRequestModel(
//                null, user.id(), achievement.id(), null, OffsetDateTime.now().toString(), Status.UNLOCKED.getValue()
//        );
//
//        userAchievementDsGateway.save(userAchievementDtoRequestModel);
//
//        return true;
//    }

    public Boolean markAchievementAsCompleted(int id) {
        UserAchievementDtoRequestModel existingUserAchievement = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));

        UserAchievementDtoRequestModel userAchievementDtoRequestModel = new UserAchievementDtoRequestModel(
                existingUserAchievement.id(),
                existingUserAchievement.userId(),
                existingUserAchievement.achievementId(),
                existingUserAchievement.imagePath(),
                OffsetDateTime.now().toString(),
                Status.FINISHED.getValue()
        );

        userAchievementDsGateway.save(userAchievementDtoRequestModel);
        return true;
    }
}