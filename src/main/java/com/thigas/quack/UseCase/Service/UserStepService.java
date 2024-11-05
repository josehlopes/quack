package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Adapter.Dto.UserStepDTO;
import com.thigas.quack.Adapter.Mapper.ObjectMapperService;
import com.thigas.quack.UseCase.Model.Request.UserStepDtoRequestModel;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.Infrastructure.Entity.UserStepDataMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserStepService {

    @Autowired
    private UserStepDsGateway userStepRepository;

    @Autowired
    private ObjectMapperService objectMapperService = new ObjectMapperService();

    @Autowired
    private StepService stepService;

    @Autowired
    private UserService userService;

    public void create(UserStepDTO userStepDTO) {
        UserStepDtoRequestModel userStepDtoRequestModel = objectMapperService.toEntity(userStepDTO);
        userStepRepository.save(objectMapperService.toModel(userStepDtoRequestModel));
    }

    public Optional<UserStepDTO> getById(int id) {
        return userStepRepository.findById(id)
                .map(objectMapperService::toDto);
    }

    public Iterable<UserStepDTO> getAll() {
        Iterable<UserStepDataMapper> userSteps = userStepRepository.findAll();
        return StreamSupport.stream(userSteps.spliterator(), false)
                .map(objectMapperService::toDto)
                .collect(Collectors.toList());
    }

    public void update(UserStepDTO userStepDTO) {
        UserStepDataMapper existingUserStep = userStepRepository.findById(userStepDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepDtoRequestModel updatedEntity = objectMapperService.toEntity(userStepDTO);
        UserStepDataMapper updatedModel = objectMapperService.toModel(updatedEntity);

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
//        UserDtoRequestModel user = objectMapperService.toEntity(userService.getById(userId).orElse(null));
//        StepDtoRequestModel step = objectMapperService.toEntity(stepService.getById(stepId).orElse(null));
//
//        if (user == null || step == null) {
//            return false;
//        }
//
//        UserStepDtoRequestModel userStepEntity = new UserStepDtoRequestModel();
//        userStepEntity.setUser(user);
//        userStepEntity.setStep(step);
//        userStepEntity.setStatus(Status.ACTIVE);
//
//        UserStepDataMapper userStepModel = objectMapperService.toModel(userStepEntity);
//        userStepRepository.save(userStepModel);
//
//        return true;
//    }

    public Boolean endStep(int id) {
        UserStepDTO existingUserStep = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepDtoRequestModel userStepDtoRequestModel = objectMapperService.toEntity(existingUserStep);
        userStepDtoRequestModel.setStatus(Status.FINISHED);

        UserStepDataMapper updatedModel = objectMapperService.toModel(userStepDtoRequestModel);
        userStepRepository.save(updatedModel);
        return true;
    }
}