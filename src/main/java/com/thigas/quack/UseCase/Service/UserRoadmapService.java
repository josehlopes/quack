package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
public class UserRoadmapService {

    private UserRoadmapDsGateway userRoadmapDsGateway;
    private RoadmapDsGateway roadmapDsGateway;
    private UserDsGateway userDsGateway;
    private StatisticsDsGateway statisticsDsGateway;

    public void create(UserRoadmapDtoRequestModel userRoadmapDtoRequest) {
        userRoadmapDsGateway.save(userRoadmapDtoRequest);
    }

    public Optional<UserRoadmapDtoRequestModel> getById(int id) {
        return userRoadmapDsGateway.findById(id);
    }

    public Iterable<UserRoadmapDtoRequestModel> getAll() {
        Iterable<UserRoadmapDtoRequestModel> userRoadmaps = userRoadmapDsGateway.findAll();
        return StreamSupport.stream(userRoadmaps.spliterator(), false)
                .collect(Collectors.toList());
    }

    public void update(UserRoadmapDtoRequestModel userRoadmapDtoRequest) {
        UserRoadmapDtoRequestModel existingUserRoadmap = userRoadmapDsGateway.findById(userRoadmapDtoRequest.id())
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        UserRoadmapDtoRequestModel updatedEntity = new UserRoadmapDtoRequestModel(
                userRoadmapDtoRequest.id(),
                userRoadmapDtoRequest.userId() != null ? userRoadmapDtoRequest.userId() : existingUserRoadmap.userId(),
                userRoadmapDtoRequest.roadmapId() != null ? userRoadmapDtoRequest.roadmapId() : existingUserRoadmap.roadmapId(),
                userRoadmapDtoRequest.progress() != null ? userRoadmapDtoRequest.progress() : existingUserRoadmap.progress(),
                userRoadmapDtoRequest.startedAt() != null ? userRoadmapDtoRequest.startedAt() : existingUserRoadmap.startedAt(),
                userRoadmapDtoRequest.finishedAt() != null ? userRoadmapDtoRequest.finishedAt() : existingUserRoadmap.finishedAt(),
                userRoadmapDtoRequest.status() != null ? userRoadmapDtoRequest.status() : existingUserRoadmap.status()
        );

        userRoadmapDsGateway.save(updatedEntity);
    }

    public void delete(int id) {
        userRoadmapDsGateway.deleteById(id);
    }

    public Boolean startRoadmap(int userId, int roadmapId) {
        if (!userDsGateway.existsById(userId) || !roadmapDsGateway.existsById(roadmapId)) {
            return false;
        }

        UserDtoRequestModel user = userDsGateway.findById(userId).orElse(null);
        RoadmapDtoRequestModel roadmap = roadmapDsGateway.findById(roadmapId).orElse(null);

        if (user == null || roadmap == null) {
            return false;
        }

        UserRoadmapDtoRequestModel userRoadmapDtoRequestModel = new UserRoadmapDtoRequestModel(
                null, user.id(), roadmap.id(), 0.0, LocalDate.now().toString(), null, Status.ACTIVE.getValue()
        );

        userRoadmapDsGateway.save(userRoadmapDtoRequestModel);

        return true;
    }

    public Boolean endRoadmap(int id) {
        UserRoadmapDtoRequestModel existingUserRoadmap = getById(id)
                .orElseThrow(() -> new EntityNotFoundException("User-Roadmap not found"));

        UserRoadmapDtoRequestModel userRoadmapDtoRequestModel = new UserRoadmapDtoRequestModel(
                existingUserRoadmap.id(),
                existingUserRoadmap.userId(),
                existingUserRoadmap.roadmapId(),
                100.0,
                existingUserRoadmap.startedAt(),
                LocalDate.now().toString(),
                Status.FINISHED.getValue()
        );

        userRoadmapDsGateway.save(userRoadmapDtoRequestModel);

        int userId = existingUserRoadmap.userId();
        statisticsDsGateway.incrementRoadmapsCompleted(userId);
        return true;
    }
}