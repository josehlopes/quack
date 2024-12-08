package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserStepService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserStepService.class);
    
    private final UserStepDsGateway userStepDsGateway;
    private final StepService stepService;
    private final UserService userService;

    public void create(UserStepRequestModel userStepDtoRequest) {
        try {
            userStepDsGateway.save(userStepDtoRequest);
        } catch (Exception e) {
            logger.error("Error creating User-Step", e);
            throw new RuntimeException("Error creating User-Step");
        }
    }

    public Optional<UserStepRequestModel> getById(int id) {
        try {
            return userStepDsGateway.findById(id);
        } catch (Exception e) {
            logger.error("Error getting User-Step by ID: {}", id, e);
            return Optional.empty();
        }
    }

    public Iterable<UserStepRequestModel> getAll() {
        try {
            Iterable<UserStepRequestModel> userSteps = userStepDsGateway.findAll();
            return StreamSupport.stream(userSteps.spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all User-Steps", e);
            return Collections.emptyList();
        }
    }

    public void update(UserStepRequestModel userStepDtoRequest) {
        try {
            UserStepRequestModel existingUserStep = userStepDsGateway.findById(userStepDtoRequest.id())
                    .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));
            
            UserStepRequestModel updatedEntity = new UserStepRequestModel(
                    userStepDtoRequest.id(),
                    userStepDtoRequest.userId() != null ? userStepDtoRequest.userId() : existingUserStep.userId(),
                    userStepDtoRequest.stepId() != null ? userStepDtoRequest.stepId() : existingUserStep.stepId(),
                    userStepDtoRequest.status() != null ? userStepDtoRequest.status() : existingUserStep.status(),
                    userStepDtoRequest.imagePath() != null ? userStepDtoRequest.imagePath() : existingUserStep.imagePath()
            );
            
            userStepDsGateway.save(updatedEntity);
        } catch (Exception e) {
            logger.error("Error updating User-Step with ID: {}", userStepDtoRequest.id(), e);
            throw new RuntimeException("Error updating User-Step");
        }
    }

    public void delete(int id) {
        try {
            if (!userStepDsGateway.existsById(id)) {
                throw new EntityNotFoundException("User-Step not found");
            }
            userStepDsGateway.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting User-Step with ID: {}", id, e);
            throw new RuntimeException("Error deleting User-Step");
        }
    }

    public Boolean startStep(int userId, int stepId) {
        try {
            if (!userService.existsById(userId) || !stepService.existsById(stepId)) {
                return false;
            }
            
            UserRequestModel user = userService.getById(userId).orElse(null);
            StepRequestModel step = stepService.getById(stepId).orElse(null);
            
            if (user == null || step == null) {
                return false;
            }
            
            UserStepRequestModel userStepRequestModel = new UserStepRequestModel(
                    null, user.id(), step.id(), Status.ACTIVE.getValue(), null
            );
            
            userStepDsGateway.save(userStepRequestModel);
            
            return true;
        } catch (Exception e) {
            logger.error("Error starting step for user ID: {} and step ID: {}", userId, stepId, e);
            return false;
        }
    }

    public Boolean endStep(int id) {
        try {
            UserStepRequestModel existingUserStep = getById(id)
                    .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));
            
            UserStepRequestModel userStepRequestModel = new UserStepRequestModel(
                    existingUserStep.id(),
                    existingUserStep.userId(),
                    existingUserStep.stepId(),
                    Status.FINISHED.getValue(),
                    existingUserStep.imagePath()
            );
            
            userStepDsGateway.save(userStepRequestModel);
            return true;
        } catch (Exception e) {
            logger.error("Error ending step with ID: {}", id, e);
            return false;
        }
    }
}