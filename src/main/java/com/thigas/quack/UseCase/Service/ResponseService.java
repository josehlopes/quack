package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import org.springframework.http.HttpStatus;

public class ResponseService {

    public ResultDtoResponseModel createSuccessResponse(String message, HttpStatus status) {
        return new ResultDtoResponseModel(message, status.value(), ResponseType.SUCCESS);
    }

    public ResultDtoResponseModel createErrorResponse(String message, HttpStatus status) {
        return new ResultDtoResponseModel(message, status.value(), ResponseType.ERROR);
    }
}