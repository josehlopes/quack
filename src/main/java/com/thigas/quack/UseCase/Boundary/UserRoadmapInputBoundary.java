package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.CompleteRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

import java.util.List;

public interface UserRoadmapInputBoundary {
    ResponseWrapper<GenericResponseModel> startRoadmap(StartRoadmapRequestModel request);
    ResponseWrapper<GenericResponseModel> completeRoadmap(CompleteRoadmapRequestModel request);
    ResponseWrapper<List<RoadmapRequestModel>> getUserRoadmapsByUserId(Integer userId);
}
