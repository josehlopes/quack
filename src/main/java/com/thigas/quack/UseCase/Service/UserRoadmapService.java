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
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserRoadmapService implements UserRoadmapInputBoundary {

    private final UserRoadmapDsGateway userRoadmapDsGateway;
    private final RoadmapDsGateway roadmapDsGateway;
    private final UserDsGateway userDsGateway;
    private final StatisticsDsGateway statisticsDsGateway;
    private final UserRoadmapFactory userRoadmapFactory;
    private final UserRoadmapMapper userRoadmapMapper;
    private final StatisticsService statisticsService;

    //TODO: ALTERAR NOME DOS MÉTODOS
    @Override
    public ResponseWrapper<GenericResponseModel> startRoadmap(StartRoadmapRequestModel request) {
        UserRoadmap userRoadmap = userRoadmapFactory.create(request.userId(), request.roadmapId());
        if (saveUserRoadmap(userRoadmap)) {
            statisticsService.addExperience(request.userId(), 50.0);
            return new ResponseWrapper<>(new GenericResponseModel("Roadmap started successfully"), 201);
        }
        return new ResponseWrapper<>(new GenericResponseModel("Roadmap start error"), 400);
    }

    private Boolean saveUserRoadmap(UserRoadmap userRoadmap) {
        UserRoadmapRequestModel userRoadmapRequestModel = userRoadmapMapper.toDsModel(userRoadmap);
        return userRoadmapDsGateway.saveUserRoadmap(userRoadmapRequestModel);
    }

    private UserRoadmapRequestModel getUserRoadmap(Integer userRoadmapId) {
        return userRoadmapDsGateway.getUserRoadmapById(userRoadmapId).get();
    }

    //TODO: USAR MÉTODO TODA VEZ QUE CONCLUIR UM STEP
    private Boolean completeRoadmap(UserRoadmapRequestModel userRoadmap) {
        UserRoadmapRequestModel existingUserRoadmap = getUserRoadmap(userRoadmap.id());
        if (isRoadmapComplete(userRoadmap)) {
            updateRoadmapStatusToFinished(existingUserRoadmap);
            statisticsService.addRoadmapCompleteCount(existingUserRoadmap.userId());
            statisticsService.addExperience(existingUserRoadmap.userId(), 200.0);
            return true;
        } else {
            return false;
        }
    }

    private boolean isRoadmapComplete(UserRoadmapRequestModel userRoadmap) {
        return userRoadmap.progress() == 100.0;
    }

    private void updateRoadmapStatusToFinished(UserRoadmapRequestModel userRoadmap) {
        CommonUserRoadmap commonUserRoadmap = userRoadmapMapper.toEntity(userRoadmap);
        commonUserRoadmap.updateStatus(Status.FINISHED);
    }
}