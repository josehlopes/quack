// src/main/java/com/thigas/quack/Adapter/Formatter/GenericResponseFormatter.java
package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Presenter.GenericPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GenericResponseFormatter implements GenericPresenter {

    @Override
    public <T> ResponseWrapper<T> prepareFailView(T error, int statusCode) {
        if (error instanceof String) {
            return new ResponseWrapper<>(statusCode);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error type");
    }

    @Override
    public <T> ResponseWrapper<T> prepareSuccessView(T response, int statusCode) {
        return new ResponseWrapper<>(response, statusCode);
    }
}