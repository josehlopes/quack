package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserDataMapper;
import com.thigas.quack.Domain.Entity.User;
import com.thigas.quack.UseCase.Model.Request.UserDsDtoRequestModel;
import com.thigas.quack.UseCase.Model.Response.UserInfoDtoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserDsDtoRequestModel toDsModel(UserDataMapper user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserDsDtoRequestModel toDsModel(User user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserInfoDtoResponseModel toInfoDto(User user);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserDataMapper toDataMapper(UserDsDtoRequestModel userDsDtoRequestModel);


    default String map(OffsetDateTime value) {
        return value != null ? value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    default OffsetDateTime map(String value) {
        return value != null ? OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }
}