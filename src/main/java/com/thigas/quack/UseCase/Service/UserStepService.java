package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserStepRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserStepService {

    private final UserStepDsGateway userStepDsGateway;

    private final StepService stepService;

    private final UserService userService;

    public void create(UserStepRequestModel userStepDtoRequest) {
        userStepDsGateway.save(userStepDtoRequest);
    }

    public Optional<UserStepRequestModel> getById(int id) {
        return userStepDsGateway.findById(id);
    }

    public Iterable<UserStepRequestModel> getAll() {
        Iterable<UserStepRequestModel> userSteps = userStepDsGateway.findAll();
        return StreamSupport.stream(userSteps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserStepRequestModel userStepDtoRequest) {
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
    }

    public void delete(int id) {
        if (!userStepDsGateway.existsById(id)) {
            throw new EntityNotFoundException("User-Step not found");
        }
        userStepDsGateway.deleteById(id);
    }

    public Boolean startStep(int userId, int stepId) {
        if (!userService.existsById(userId) || !stepService.existsById(stepId)) {
            return false;
        }

        UserDsRequestModel user = userService.getById(userId).orElse(null);
        StepRequestModel step = stepService.getById(stepId).orElse(null);

        if (user == null || step == null) {
            return false;
        }

        UserStepRequestModel userStepRequestModel = new UserStepRequestModel(
                null, user.id(), step.id(), Status.ACTIVE.getValue(), null
        );

        userStepDsGateway.save(userStepRequestModel);

        return true;
    }

    public Boolean endStep(int id) {
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
    }
}