package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ResultDtoResponseModel;

public interface AddressPresenter {
    AddressInfoDtoResponseModel prepareGetAddressSuccessView(AddressInfoDtoResponseModel address);

    AddressInfoDtoResponseModel prepareGetAddressFailView(ResultDtoResponseModel error);
}
