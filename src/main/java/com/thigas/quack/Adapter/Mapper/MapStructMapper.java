package com.thigas.quack.Adapter.Mapper;

import com.thigas.quack.Adapter.Mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.Infrastructure.Entity.*;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper {

    //TODO: Estudar melhor o uso do @Context
    //TODO: Estudar mais sobre mapstruct e ver como funciona os campos ignoraveis
    //TODO: Talvez estudar sobre ModelMapper

    UserDataMapper mapUserRegisterDtoToUserDataMapper(UserRegisterDtoRequestModel userRegisterDtoRequestModel);

    UserLoginDtoResponseModel mapUserDataMapperToUserLoginDtoResponse(UserDataMapper userDataMapper);

    UserDtoRequestModel mapUserDataMapperToUserDtoRequest(UserDataMapper userDataMapper);

    UserDataMapper mapUserDtoRequestToUserDataMapper(UserDtoRequestModel userDtoRequestModel);

}