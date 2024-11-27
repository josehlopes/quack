package com.thigas.quack.UseCase.Boundary;

import com.thigas.quack.UseCase.Model.Request.AddressCreateRequestModel;
import com.thigas.quack.UseCase.Model.Request.AddressRequestModel;
import com.thigas.quack.UseCase.Model.Response.AddressInfoResponseModel;
import com.thigas.quack.UseCase.Model.Response.GenericResponseModel;
import com.thigas.quack.UseCase.Util.ResponseWrapper;

import java.util.Optional;

public interface AddressInputBoundary {
    ResponseWrapper<GenericResponseModel> create(AddressCreateRequestModel request);

    ResponseWrapper<GenericResponseModel> update(AddressRequestModel request);

    ResponseWrapper<GenericResponseModel> delete(Integer id);
}
