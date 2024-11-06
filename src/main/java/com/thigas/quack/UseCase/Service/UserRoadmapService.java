package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.UseCase.Model.Request.RoadmapDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserDtoRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapDtoRequestModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserRoadmapService {

    @Autowired
    private UserRoadmapDsGateway userRoadmapDsGateway;


    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private UserService userService;

    @Autowired
    private StatisticsService statisticsService;

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
        if (!userService.existsById(userId) || !roadmapService.existsById(roadmapId)) {
            return false;
        }

        UserDtoRequestModel user = userService.getById(userId).orElse(null);
        RoadmapDtoRequestModel roadmap = roadmapService.getById(roadmapId).orElse(null);

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
        statisticsService.incrementRoadmapsCompleted(userId);
        return true;
    }
}