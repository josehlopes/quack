package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Domain.Entity.Interface.User;
import com.thigas.quack.UseCase.Model.Request.UserRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserRequestModel toDsModel(UserDataMapper user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserRequestModel toDsModel(User user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserInfoResponseModel toInfoDto(User user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserDataMapper toDataMapper(UserRequestModel userRequestModel);

}