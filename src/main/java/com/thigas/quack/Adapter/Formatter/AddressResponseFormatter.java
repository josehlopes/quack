package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressResponseFormatter implements AddressPresenter {

    @Override
    public AddressInfoDtoResponseModel prepareGetAddressSuccessView(AddressInfoDtoResponseModel address) {
        return new AddressInfoDtoResponseModel(
                address.street(),
                address.city(),
                address.state(),
                address.country(),
                address.zipCode(),
                address.number()
        );
    }

    @Override
    public AddressInfoDtoResponseModel prepareGetAddressFailView(ErrorDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.valueOf(error.errorCode()), error.errorMessage());
    }
}