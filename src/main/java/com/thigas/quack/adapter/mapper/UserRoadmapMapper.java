package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.Named;

@Mapper(uses = {UserMapper.class, RoadmapMapper.class}, componentModel = "spring")
public interface UserRoadmapMapper {

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "roadmap.id", target = "roadmap")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapMapperStatusToInt")
    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "roadmap", target = "roadmap.id")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapMapperIntToStatus")
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "roadmap.id", target = "roadmap.id")
    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "roadmap.id", target = "roadmap.id")
    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "roadmap", target = "roadmap.id")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapMapperIntToStatus")
    UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "roadmap.id", target = "roadmap")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapMapperStatusToInt")
    UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

    default UserModel userRoadmapIntegerToModel(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(user, UserModel.class, context);
    }

    default Integer userRoadmapModelToInteger(UserModel userModel) {
        return MapperUtils.modelToInteger(userModel);
    }

    default RoadmapModel roadmapIntegerToModel(Integer roadmap, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(roadmap, RoadmapModel.class, context);
    }

    default Integer roadmapModelToInteger(RoadmapModel roadmapModel) {
        return MapperUtils.modelToInteger(roadmapModel);
    }

    default UserEntity userRoadmapIntegerToEntity(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToEntity(user, UserEntity.class, context);
    }

    default Integer userRoadmapEntityToInteger(UserEntity userEntity) {
        return MapperUtils.modelToInteger(userEntity);
    }

    default RoadmapEntity roadmapIntegerToEntity(Integer roadmap, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToEntity(roadmap, RoadmapEntity.class, context);
    }

    default Integer roadmapEntityToInteger(RoadmapEntity roadmapModel) {
        return MapperUtils.modelToInteger(roadmapModel);
    }

    @Named("userRoadmapMapperStatusToInt")
    default int userRoadmapMapStatusToInteger(Status status) {
        return MapperUtils.statusToInt(status);
    }

    @Named("userRoadmapMapperIntToStatus")
    default Status userRoadmapMapIntegerToStatus(int value) {
        return MapperUtils.intToStatus(value);
    }
}