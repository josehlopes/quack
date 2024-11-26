// src/main/java/com/thigas/quack/Adapter/Formatter/UserResponseFormatter.java
package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Presenter.UserPresenter;
import com.thigas.quack.UseCase.Util.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserResponseFormatter implements UserPresenter {

    @Override
    public <T> ResponseWrapper<T> prepareFailView(T error, int statusCode) {
        if (error instanceof String) {
            return new ResponseWrapper<>((String) error, statusCode);
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error type");
    }

    @Override
    public <T> ResponseWrapper<T> prepareSuccessView(T response, int statusCode) {
        return new ResponseWrapper<>(response, statusCode);
    }
}