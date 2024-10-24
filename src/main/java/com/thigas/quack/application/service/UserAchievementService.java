//package com.thigas.quack.application.service;
//
//import com.thigas.quack.adapter.dto.UserAchievementDTO;
//import com.thigas.quack.domain.entity.AchievementEntity;
//import com.thigas.quack.domain.entity.UserAchievementEntity;
//import com.thigas.quack.domain.entity.UserEntity;
//import com.thigas.quack.domain.model.Status;
//import com.thigas.quack.domain.repository.IUserAchievementRepository;
//import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.Optional;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//@Service
//public class UserAchievementService {
//
//    @Autowired
//    private IUserAchievementRepository userAchievementRepository;
//
//    @Autowired
//    private ObjectMapperService objectMapperService;
//
//    @Autowired
//    private AchievementService achievementService;
//
//    @Autowired
//    private UserService userService;
//
//    public UserAchievementDTO create(UserAchievementDTO userAchievementDTO) {
//        UserAchievementEntity userAchievementEntity = objectMapperService.toEntity(userAchievementDTO);
//        UserAchievementModel savedUserAchievement = userAchievementRepository.save(objectMapperService.toModel(userAchievementEntity));
//        return objectMapperService.toDto(savedUserAchievement);
//    }
//
//    public Optional<UserAchievementDTO> getById(int id) {
//        return userAchievementRepository.findById(id)
//                .map(objectMapperService::toDto);
//    }
//
//    public Iterable<UserAchievementDTO> getAll() {
//        Iterable<UserAchievementModel> userAchievements = userAchievementRepository.findAll();
//        return StreamSupport.stream(userAchievements.spliterator(), false)
//                .map(objectMapperService::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public void update(UserAchievementDTO userAchievementDTO) {
//        UserAchievementModel existingUserAchievement = userAchievementRepository.findById(userAchievementDTO.getId())
//                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));
//
//        UserAchievementEntity updatedEntity = objectMapperService.toEntity(userAchievementDTO);
//        UserAchievementModel updatedModel = objectMapperService.toModel(updatedEntity);
//
//        userAchievementRepository.save(updatedModel);
//    }
//
//    public void delete(int id) {
//        userAchievementRepository.deleteById(id);
//    }
//
//    public Boolean unlockAchievement(int userId, int achievementId) {
//        if (!userService.existsById(userId) || !achievementService.existsById(achievementId)) {
//            return false;
//        }
//
//        UserEntity user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
//        AchievementEntity achievement = objectMapperService.toEntity(achievementService.getById(achievementId).orElse(null));
//
//        if (user == null || achievement == null) {
//            return false;
//        }
//
//        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();
//        userAchievementEntity.setUser(user);
//        userAchievementEntity.setAchievement(achievement);
//        userAchievementEntity.setObtainedDate(LocalDate.now());
//        userAchievementEntity.setStatus(Status.UNLOCKED);
//
//        UserAchievementModel userAchievementModel = objectMapperService.toModel(userAchievementEntity);
//        userAchievementRepository.save(userAchievementModel);
//
//        return true;
//    }
//
//    public Boolean markAchievementAsCompleted(int id) {
//        UserAchievementDTO existingUserAchievement = getById(id)
//                .orElseThrow(() -> new EntityNotFoundException("User-Achievement not found"));
//
//        UserAchievementEntity userAchievementEntity = objectMapperService.toEntity(existingUserAchievement);
//
//        userAchievementEntity.setStatus(Status.COMPLETED);
//        userAchievementEntity.setCompletedDate(LocalDate.now());
//
//        UserAchievementModel updatedModel = objectMapperService.toModel(userAchievementEntity);
//        userAchievementRepository.save(updatedModel);
//        return true;
//    }
//}