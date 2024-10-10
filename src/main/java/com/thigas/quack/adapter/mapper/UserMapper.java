package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserMapper {

    @Mappings({@Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "offsetDateTimeToString"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")})
    UserDTO entityToDto(UserEntity user, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "stringToOffsetDateTime"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")})
    UserEntity dtoToEntity(UserDTO userDTO, @Context CycleAvoidingMappingContext context);

    UserModel entityToModel(UserEntity userEntity, @Context CycleAvoidingMappingContext context);

    UserEntity modelToEntity(UserModel userModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "stringToOffsetDateTime"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")})
    UserModel dtoToModel(UserDTO userDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "offsetDateTimeToString"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")})
    UserDTO modelToDto(UserModel userModel, @Context CycleAvoidingMappingContext context);


}
