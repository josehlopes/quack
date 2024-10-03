package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userAchievements", target = "userAchievements")
    UserDTO entityToDto(UserEntity user, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userAchievements", target = "userAchievements")
    UserEntity dtoToEntity(UserDTO userDTO, @Context CycleAvoidingMappingContext context);

    UserModel entityToModel(UserEntity userEntity, @Context CycleAvoidingMappingContext context);
    UserEntity modelToEntity(UserModel userModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userAchievements", target = "userAchievements")
    UserModel dtoToModel(UserDTO userDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "bornAt", target = "bornAt", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "registerAt", target = "registerAt", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "userAchievements", target = "userAchievements")
    UserDTO modelToDto(UserModel userModel, @Context CycleAvoidingMappingContext context);

    default Set<UserModel> integersToUserModelId(Set<Integer> users, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(users, UserModel.class, context);
    }

    default Set<Integer> userModelIdToIntegers(Set<UserModel> users) {
        return MapperUtils.modelsToIntegers(users);
    }

    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> users, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(users, RoadmapEntity.class, context);
    }

    default Set<Integer> userEntityToIntegers(Set<RoadmapEntity> users) {
        return MapperUtils.entitiesToIntegers(users);

    }
    default Set<UserAchievementModel> integersToUserAchievementModels(Set<Integer> usersAchievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(usersAchievement, UserAchievementModel.class, context);
    }

    default Set<Integer> userAchievementModelsToIntegers(Set<UserAchievementModel> usersAchievement) {
        return MapperUtils.modelsToIntegers(usersAchievement);
    }

    default Set<UserAchievementEntity> integersToUserAchievementEntities(Set<Integer> usersAchievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(usersAchievement, UserAchievementEntity.class, context);
    }

    default Set<Integer> userAchievementEntitiesToIntegers(Set<UserAchievementEntity> usersAchievement) {
        return MapperUtils.entitiesToIntegers(usersAchievement);
    }

    default OffsetDateTime offSetToString(String date) {
        if (date == null) {
            return null;
        }
        return OffsetDateTime.parse(date);
    }

    default String stringToOffSet(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }

    default int userStatusToInteger(Status status) {
        return MapperUtils.statusToInt(status);
    }

    default Status userIntegerToStatus(int value) {
        return MapperUtils.intToStatus(value);
    }
    }



