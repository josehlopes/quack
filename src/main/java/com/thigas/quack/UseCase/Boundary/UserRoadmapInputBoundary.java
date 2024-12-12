package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.CompleteRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface UserRoadmapInputBoundary {
    ResponseWrapper<GenericResponseModel> startRoadmap(StartRoadmapRequestModel request);
    ResponseWrapper<GenericResponseModel> completeRoadmap(CompleteRoadmapRequestModel request);
}
