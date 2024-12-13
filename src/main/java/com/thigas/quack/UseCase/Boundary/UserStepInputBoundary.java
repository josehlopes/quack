package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.EndStepRequestModel;
import com.thigas.quack.UseCase.Model.Request.StartStepRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface UserStepInputBoundary {
    ResponseWrapper<GenericResponseModel> startStep(StartStepRequestModel request);
    ResponseWrapper<GenericResponseModel> endStep(EndStepRequestModel request);
}
