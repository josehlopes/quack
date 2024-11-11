package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserStepDsGateway;
import com.thigas.quack.UseCase.Model.Request.StepDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserStepDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserStepService {

    private final UserStepDsGateway userStepDsGateway;

    private final StepService stepService;

    private final UserService userService;

    public void create(UserStepDtoRequestModel userStepDtoRequest) {
        userStepDsGateway.save(userStepDtoRequest);
    }

    public Optional<UserStepDtoRequestModel> getById(int id) {
        return userStepDsGateway.findById(id);
    }

    public Iterable<UserStepDtoRequestModel> getAll() {
        Iterable<UserStepDtoRequestModel> userSteps = userStepDsGateway.findAll();
        return StreamSupport.stream(userSteps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserStepDtoRequestModel userStepDtoRequest) {
        UserStepDtoRequestModel existingUserStep = userStepDsGateway.findById(userStepDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepDtoRequestModel updatedEntity = new UserStepDtoRequestModel(
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

        UserDtoRequestModel user = userService.getById(userId).orElse(null);
        StepDtoRequestModel step = stepService.getById(stepId).orElse(null);

        if (user == null || step == null) {
            return false;
        }

        UserStepDtoRequestModel userStepDtoRequestModel = new UserStepDtoRequestModel(
                null, user.id(), step.id(), Status.ACTIVE.getValue(), null
        );

        userStepDsGateway.save(userStepDtoRequestModel);

        return true;
    }

    public Boolean endStep(int id) {
        UserStepDtoRequestModel existingUserStep = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Step not found"));

        UserStepDtoRequestModel userStepDtoRequestModel = new UserStepDtoRequestModel(
                existingUserStep.id(),
                existingUserStep.userId(),
                existingUserStep.stepId(),
                Status.FINISHED.getValue(),
                existingUserStep.imagePath()
        );

        userStepDsGateway.save(userStepDtoRequestModel);
        return true;
    }
}