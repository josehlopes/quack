package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;

public interface AddressPresenter {
    AddressInfoResponseModel prepareGetAddressSuccessView(AddressInfoResponseModel address);

    AddressInfoResponseModel prepareGetAddressFailView(GenericResponseModel error);
}
