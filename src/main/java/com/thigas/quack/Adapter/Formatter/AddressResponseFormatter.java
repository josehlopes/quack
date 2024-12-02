package com.thigas.quack.Adapter.Formatter;

import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Presenter.AddressPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AddressResponseFormatter implements AddressPresenter {

    @Override
    public AddressInfoResponseModel prepareGetAddressSuccessView(AddressInfoResponseModel address) {
        return new AddressInfoResponseModel(
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
    public AddressInfoResponseModel prepareGetAddressFailView(GenericResponseModel error) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, error.message());
    }
}