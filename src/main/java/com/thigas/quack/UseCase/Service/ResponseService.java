package com.thigas.quack.UseCase.Service;

import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import org.springframework.http.HttpStatus;

public class ResponseService {

    public GenericResponseModel createSuccessResponse(String message, HttpStatus status) {
        return new GenericResponseModel(message, status.value(), ResponseType.SUCCESS);
    }

    public GenericResponseModel createErrorResponse(String message, HttpStatus status) {
        return new GenericResponseModel(message, status.value(), ResponseType.ERROR);
    }
}