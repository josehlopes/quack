package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.Domain.Utils.ResponseType;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressResponseFormatter implements AddressPresenter {

    @Override
    public AddressInfoDtoResponseModel prepareGetAddressSuccessView(AddressInfoDtoResponseModel address) {
        return new AddressInfoDtoResponseModel(
                address.id(),
                address.street(),
                address.city(),
                address.state(),
                address.country(),
                address.zipCode(),
                address.number()
        );
    }

    @Override
    public AddressInfoDtoResponseModel prepareGetAddressFailView(ResultDtoResponseModel error) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.message());
    }
}