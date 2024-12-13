package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Entity.Implementation.CommonUserRoadmap;
import com.thigas.quack.Domain.Entity.Interface.UserRoadmap;
import com.thigas.quack.Domain.Factory.Interface.UserRoadmapFactory;
import com.thigas.quack.Domain.Utils.Status;
import com.thigas.quack.UseCase.Boundary.UserRoadmapInputBoundary;
import com.thigas.quack.UseCase.Gateway.RoadmapDsGateway;
import com.thigas.quack.UseCase.Gateway.StatisticsDsGateway;
import com.thigas.quack.UseCase.Gateway.UserDsGateway;
import com.thigas.quack.UseCase.Gateway.UserRoadmapDsGateway;
import com.thigas.quack.UseCase.Mapper.UserRoadmapMapper;
import com.thigas.quack.UseCase.Model.Request.CompleteRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class UserRoadmapService implements UserRoadmapInputBoundary {
    
    private static final Logger logger = LoggerFactory.getLogger(UserRoadmapService.class);
    
    private final UserRoadmapDsGateway userRoadmapDsGateway;
    private final RoadmapDsGateway roadmapDsGateway;
    private final UserDsGateway userDsGateway;
    private final StatisticsDsGateway statisticsDsGateway;
    private final UserRoadmapFactory userRoadmapFactory;
    private final UserRoadmapMapper userRoadmapMapper;
    private final StatisticsService statisticsService;

    @Override
    public ResponseWrapper<GenericResponseModel> startRoadmap(StartRoadmapRequestModel request) {
        try {
            UserRoadmap userRoadmap = userRoadmapFactory.create(request.userId(), request.roadmapId());
            if (saveUserRoadmap(userRoadmap)) {
                statisticsService.addExperience(request.userId(), 50.0);

                Map<String, Object> responseData = new HashMap<>();
                responseData.put("id", userRoadmap.getId());
                GenericResponseModel responseModel = new GenericResponseModel("Roadmap started successfully", responseData);
                return new ResponseWrapper<>(responseModel, 201);
            }
            return new ResponseWrapper<>(new GenericResponseModel("Roadmap start error"), 400);
        } catch (Exception e) {
            logger.error("Error starting roadmap for user ID: {}", request.userId(), e);
            return new ResponseWrapper<>(new GenericResponseModel("Error starting roadmap"), 500);
        }
    }

    private Boolean saveUserRoadmap(UserRoadmap userRoadmap) {
        try {
            UserRoadmapRequestModel userRoadmapRequestModel = userRoadmapMapper.toDsModel(userRoadmap);
            return userRoadmapDsGateway.saveUserRoadmap(userRoadmapRequestModel);
        } catch (Exception e) {
            logger.error("Error saving user roadmap", e);
            throw new RuntimeException("Error saving user roadmap");
        }
    }

    private UserRoadmapRequestModel getUserRoadmap(Integer userRoadmapId) {
        try {
            return userRoadmapDsGateway.getUserRoadmapById(userRoadmapId)
                    .orElseThrow(() -> new RuntimeException("User roadmap not found"));
        } catch (Exception e) {
            logger.error("Error getting user roadmap by ID: {}", userRoadmapId, e);
            throw new RuntimeException("Error getting user roadmap");
        }
    }

    @Override
    public ResponseWrapper<GenericResponseModel> completeRoadmap(CompleteRoadmapRequestModel request) {
        try {
            UserRoadmapRequestModel existingUserRoadmap = getUserRoadmap(request.id());

            existingUserRoadmap = updateProgressToComplete(existingUserRoadmap);

            if (isRoadmapComplete(existingUserRoadmap)) {
                updateRoadmapStatusToFinished(existingUserRoadmap);

                statisticsService.addRoadmapCompleteCount(existingUserRoadmap.userId());
                statisticsService.addExperience(existingUserRoadmap.userId(), 200.0);

                return new ResponseWrapper<>(new GenericResponseModel("Roadmap completed successfully"), 200);
            } else {
                return new ResponseWrapper<>(new GenericResponseModel("Roadmap is not yet complete"), 400);
            }
        } catch (RuntimeException e) {
            logger.error("Error completing roadmap for user roadmap ID: {}", request.id(), e);
            return new ResponseWrapper<>(new GenericResponseModel("Error completing roadmap"), 500);
        }
    }


    private UserRoadmapRequestModel updateProgressToComplete(UserRoadmapRequestModel userRoadmap) {
        try {
            userRoadmap = new UserRoadmapRequestModel(
                    userRoadmap.id(),
                    userRoadmap.userId(),
                    userRoadmap.roadmapId(),
                    100.0,
                    userRoadmap.startedIn(),
                    userRoadmap.finishedIn(),
                    2

            );
            userRoadmapDsGateway.updateProgressToComplete(userRoadmap);
            return userRoadmap;
        } catch (Exception e) {
            logger.error("Error updating roadmap progress to 100%", e);
            throw new RuntimeException("Error updating roadmap progress");
        }
    }

    private boolean isRoadmapComplete(UserRoadmapRequestModel userRoadmap) {
        return userRoadmap.progress() == 100.0;
    }


    private void updateRoadmapStatusToFinished(UserRoadmapRequestModel userRoadmap) {
        try {
            CommonUserRoadmap commonUserRoadmap = userRoadmapMapper.toEntity(userRoadmap);
            commonUserRoadmap.updateStatus(Status.FINISHED);
        } catch (Exception e) {
            logger.error("Error updating roadmap status to finished", e);
            throw new RuntimeException("Error updating roadmap status");
        }
    }
}