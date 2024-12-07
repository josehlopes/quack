package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

public interface AddressInputBoundary {
    ResponseWrapper<GenericResponseModel> createAddress(AddressCreateRequestModel request);

    ResponseWrapper<GenericResponseModel> updateAddress(AddressRequestModel request);

    ResponseWrapper<GenericResponseModel> deleteAddress(Integer id);
}
