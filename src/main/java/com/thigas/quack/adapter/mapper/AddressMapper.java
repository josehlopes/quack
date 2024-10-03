package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AddressDTO;
import com.thigas.quack.domain.entity.AddressEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.AddressModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "status", target = "status")
    AddressEntity dtoToEntity(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "status", target = "status")
    AddressDTO entityToDto(AddressEntity address, @Context CycleAvoidingMappingContext context);

    AddressModel entityToModel(AddressEntity address, @Context CycleAvoidingMappingContext context);

    AddressEntity modelToEntity(AddressModel addressModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "status", target = "status")
    AddressModel dtoToModel(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "status", target = "status")
    AddressDTO modelToDto(AddressModel addressModel, @Context CycleAvoidingMappingContext context);

    default UserModel userRoadmapIntegerToModel(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToModel(user, UserModel.class, context);
    }

    default Integer userRoadmapModelToInteger(UserModel userModel) {
        return MapperUtils.modelToInteger(userModel);
    }

    default UserEntity userRoadmapIntegerToEntity(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToEntity(user, UserEntity.class, context);
    }

    default Integer userRoadmapEntityToInteger(UserEntity userEntity) {
        return MapperUtils.modelToInteger(userEntity);
    }

    default int addressMapStatusToInt(Status status) {
        return MapperUtils.statusToInt(status);
    }

    default Status addressMapIntToStatus(int value) {
        return MapperUtils.intToStatus(value);
    }
}