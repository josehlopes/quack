package com.thigas.quack.UseCase.Presenter;

import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.ErrorDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.SuccessDtoResponseModel;

public interface AddressPresenter {
    AddressInfoDtoResponseModel prepareGetAddressSuccessView(AddressInfoDtoResponseModel address);
    AddressInfoDtoResponseModel prepareGetAddressFailView(ErrorDtoResponseModel error);
}
