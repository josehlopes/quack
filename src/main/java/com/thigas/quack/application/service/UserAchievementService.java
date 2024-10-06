package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.adapter.mapper.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.StepMapper;
import com.thigas.quack.adapter.mapper.UserAchievementMapper;
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
    private UserAchievementMapper userAchievementMapper;

    @Autowired
    private CycleAvoidingMappingContext context;


    public UserAchievementDTO create(UserAchievementDTO userAchievementDTO) {
        UserAchievementModel userAchievementModel = userAchievementMapper.dtoToModel(userAchievementDTO, context);
        UserAchievementModel savedUserModel = userAchievementRepository.save(userAchievementModel);
        return userAchievementMapper.modelToDto(savedUserModel, context);
    }

    public Optional<UserAchievementDTO> getById(int id) {
        Optional<UserAchievementModel> userAchievementOpt = userAchievementRepository.findById(id);
        return userAchievementOpt.map(userAchievement -> userAchievementMapper.modelToDto(userAchievement, new CycleAvoidingMappingContext()));
    }

    public Iterable<UserAchievementDTO> getAll() {
        Iterable<UserAchievementModel> userAchievementsOpt = userAchievementRepository.findAll();
        return StreamSupport.stream(userAchievementsOpt.spliterator(), false).map(userAchievement -> userAchievementMapper.modelToDto(userAchievement, new CycleAvoidingMappingContext()))
                .collect(Collectors.toList());
    }

    public void update(UserAchievementDTO userAchievementDTO) {
        UserAchievementModel existingUser = userAchievementRepository.findById(userAchievementDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("UserAchievement not found"));
        userAchievementRepository.save(existingUser);
    }

    public void delete(int id) {
        userAchievementRepository.deleteById(id);
    }
}
