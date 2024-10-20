package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.UserStepDTO;
import com.thigas.quack.domain.entity.UserStepEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.domain.repository.IUserStepRepository;
import com.thigas.quack.infrastructure.persistence.entity.UserStepModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserStepService {

    @Autowired
    private IUserStepRepository userStepRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private StepService stepService;

    @Autowired
    private UserService userService;

    public UserStepDTO create(UserStepDTO userStepDTO) {
        UserStepEntity userStepEntity = objectMapperService.toEntity(userStepDTO);
        UserStepModel savedUserStep = userStepRepository.save(objectMapperService.toModel(userStepEntity));
        return objectMapperService.toDto(savedUserStep);
    }

    public Optional<UserStepDTO> getById(int id) {
        return userStepRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserStepDTO> getAll() {
        Iterable<UserStepModel> userSteps = userStepRepository.findAll();
        return StreamSupport.stream(userSteps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(UserStepDTO userStepDTO) {
        UserStepModel existingUserStep = userStepRepository.findById(userStepDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepEntity updatedEntity = objectMapperService.toEntity(userStepDTO);
        UserStepModel updatedModel = objectMapperService.toModel(updatedEntity);

        userStepRepository.save(updatedModel);
    }

    public void delete(int id) {
        userStepRepository.deleteById(id);
    }

//    public Boolean startStep(int userId, int stepId) {
//        if (!userService.existsById(userId) || !stepService.existsById(stepId)) {
//            return false;
//        }
//
//        UserEntity user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
//        StepEntity step = objectMapperService.toEntity(stepService.getById(stepId).orElse(null));
//
//        if (user == null || step == null) {
//            return false;
//        }
//
//        UserStepEntity userStepEntity = new UserStepEntity();
//        userStepEntity.setUser(user);
//        userStepEntity.setStep(step);
//        userStepEntity.setStatus(Status.ACTIVE);
//
//        UserStepModel userStepModel = objectMapperService.toModel(userStepEntity);
//        userStepRepository.save(userStepModel);
//
//        return true;
//    }

    public Boolean endStep(int id) {
        UserStepDTO existingUserStep = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepEntity userStepEntity = objectMapperService.toEntity(existingUserStep);
        userStepEntity.setStatus(Status.FINISHED);

        UserStepModel updatedModel = objectMapperService.toModel(userStepEntity);
        userStepRepository.save(updatedModel);
        return true;
    }
}