package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.UserStepInputBoundary;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
public class UserStepService implements UserStepInputBoundary {
    
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
            return userStepDsGateway.getById(id);
        } catch (Exception e) {
            logger.error("Error getting User-Step by ID: {}", id, e);
            return Optional.empty();
        }
    }

    public Iterable<UserStepRequestModel> getAll() {
        try {
            Iterable<UserStepRequestModel> userSteps = userStepDsGateway.getAll();
            return StreamSupport.stream(userSteps.spliterator(), false)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error getting all User-Steps", e);
            return Collections.emptyList();
        }
    }

    public void update(UserStepRequestModel userStepDtoRequest) {
        try {
            UserStepRequestModel existingUserStep = userStepDsGateway.getById(userStepDtoRequest.id())
                    .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));
            
            UserStepRequestModel updatedEntity = new UserStepRequestModel(
                    userStepDtoRequest.id(),
                    userStepDtoRequest.userId() != null ? userStepDtoRequest.userId() : existingUserStep.userId(),
                    userStepDtoRequest.stepId() != null ? userStepDtoRequest.stepId() : existingUserStep.stepId(),
                    userStepDtoRequest.status() != null ? userStepDtoRequest.status() : existingUserStep.status()
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

    public List<UserStepRequestModel> getStepsByUserId(Integer userId) {
        try {
            return userStepDsGateway.getStepsByUserId(userId);
        } catch (Exception e) {
            logger.error("Error getting steps for User ID: {}", userId, e);
            return List.of();
        }
    }

    public ResponseWrapper<GenericResponseModel> startStep(StartStepRequestModel request) {
        try {
            if (!userService.existsById(request.userId())) {
                logger.warn("User not found with ID: {}", request.userId());
                return new ResponseWrapper<>(new GenericResponseModel("User not found"), 404);
            }
            if (!stepService.existsById(request.stepId())) {
                logger.warn("Step not found with ID: {}", request.stepId());
                return new ResponseWrapper<>(new GenericResponseModel("Step not found"), 404);
            }

            UserRequestModel user = userService.getById(request.userId()).orElseThrow(() ->
                    new IllegalStateException("User retrieval failed despite existence check")
            );
            StepRequestModel step = stepService.getById(request.stepId()).orElseThrow(() ->
                    new IllegalStateException("Step retrieval failed despite existence check")
            );

            if (user.id() == null || step.id() == null) {
                logger.error("User or Step has null ID - User ID: {}, Step ID: {}", user.id(), step.id());
                return new ResponseWrapper<>(new GenericResponseModel("Invalid user or step data"), 400);
            }

            logger.debug("Creating UserStepRequestModel with User ID: {} and Step ID: {}", user.id(), step.id());

            UserStepRequestModel userStepRequestModel = new UserStepRequestModel(
                    null, user.id(), step.id(), Status.ACTIVE.getValue()
            );

            userStepDsGateway.save(userStepRequestModel);

            logger.info("Step started successfully for User ID: {} and Step ID: {}", user.id(), step.id());
            return new ResponseWrapper<>(new GenericResponseModel("Step started successfully"), 200);

        } catch (Exception e) {
            logger.error("Error starting step for user ID: {} and step ID: {}", request.userId(), request.stepId(), e);
            return new ResponseWrapper<>(new GenericResponseModel("Error starting step"), 500);
        }
    }




    public ResponseWrapper<GenericResponseModel> endStep(EndStepRequestModel request) {
        try {
            UserStepRequestModel existingUserStep = getById(request.id())
                    .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

            UserStepRequestModel userStepRequestModel = new UserStepRequestModel(
                    existingUserStep.id(),
                    existingUserStep.userId(),
                    existingUserStep.stepId(),
                    Status.FINISHED.getValue()
            );

            userStepDsGateway.update(userStepRequestModel);
            return new ResponseWrapper<>(new GenericResponseModel("Step ended successfully"), 200);
        } catch (Exception e) {
            logger.error("Error ending step with ID: {}", request.id(), e);
            return new ResponseWrapper<>(new GenericResponseModel("Error ending step"), 500);
        }
    }
}