//package com.thigas.quack.application.service;
//
//import com.thigas.quack.adapter.dto.UserAchievementDTO;
//import com.thigas.quack.adapter.mapper.UserAchievementMapper;
//import com.thigas.quack.domain.repository.IUserAchievementRepository;
//import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
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
//    private UserAchievementMapper userAchievementMapper;
//
//    public UserAchievementDTO create(UserAchievementDTO userAchievementDTO) {
//        UserAchievementModel userAchievementModel = userAchievementMapper.dtoToModel(userAchievementDTO);
//        UserAchievementModel savedUserModel = userAchievementRepository.save(userAchievementModel);
//        return userAchievementMapper.modelToDto(savedUserModel);
//    }
//
//    public Optional<UserAchievementDTO> getById(int id) {
//        Optional<UserAchievementModel> userAchievement = userAchievementRepository.findById(id);
//        return userAchievement.map(userAchievementMapper::modelToDto);
//    }
//
//    public Iterable<UserAchievementDTO> getAll() {
//        Iterable<UserAchievementModel> userAchievements = userAchievementRepository.findAll();
//        return StreamSupport.stream(userAchievements.spliterator(), false).map(userAchievementMapper::modelToDto)
//                .collect(Collectors.toList());
//    }
//
//    public void update(UserAchievementDTO userAchievementDTO) {
//        UserAchievementModel existingUser = userAchievementRepository.findById(userAchievementDTO.getId())
//                .orElseThrow(() -> new EntityNotFoundException("UserAchievement not found"));
//        userAchievementRepository.save(existingUser);
//    }
//
//    public void delete(int id) {
//        userAchievementRepository.deleteById(id);
//    }
//}
