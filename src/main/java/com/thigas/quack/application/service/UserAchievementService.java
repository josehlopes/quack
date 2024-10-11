//package com.thigas.quack.application.service;
//
//import com.thigas.quack.domain.entity.UserAchievementEntity;
//import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
//import com.thigas.quack.domain.repository.IUserAchievementRepository;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
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
//    public UserAchievementEntity create(UserAchievementEntity userAchievementDTO) {
//        UserAchievementEntity userAchievementModel = objectMapperService.toModel(userAchievementDTO);
//        UserAchievementEntity savedUserModel = userAchievementRepository.save(userAchievementModel);
//        return objectMapperService.toDto(savedUserModel);
//    }
//
//    public Optional<UserAchievementEntity> getById(int id) {
//        return userAchievementRepository.findById(id)
//                .map(objectMapperService::toDto);
//    }
//
//    public Iterable<UserAchievementEntity> getAll() {
//        Iterable<UserAchievementEntity> userAchievements = userAchievementRepository.findAll();
//        return StreamSupport.stream(userAchievements.spliterator(), false)
//                .map(objectMapperService::toDto)
//                .collect(Collectors.toList());
//    }
//
//    public void update(UserAchievementEntity userAchievementDTO) {
//        UserAchievementEntity existingUserAchievement = userAchievementRepository.findById(userAchievementDTO.getId())
//                .orElseThrow(() -> new EntityNotFoundException("UserAchievement not found"));
//
//        existingUserAchievement.setId(userAchievementDTO.getId());
//
//        userAchievementRepository.save(existingUserAchievement);
//    }
//
//    public void delete(int id) {
//        if (!userAchievementRepository.existsById(id)) {
//            throw new IllegalArgumentException("UserAchievement não encontrado com id: " + id);
//        }
//        userAchievementRepository.deleteById(id);
//    }
//}
