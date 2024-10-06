package com.thigas.quack.adapter.mapper;


import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import org.mapstruct.*;

import java.util.Set;


@Mapper(uses = {UserMapper.class, AchievementMapper.class}, componentModel = "spring")
public interface UserAchievementMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement")})
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id")})
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement")})
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id")})
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    @Named("achievementEntityToIntegers")
    default Set<Integer> userAchievementEntityToIntegers(Set<UserAchievementEntity> userAchievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(userAchievements);
    }

    @Named("integersToUserAchievementEntityId")
    default Set<UserAchievementEntity> integersToUserAchievementEntityId(Set<Integer> userAchievementIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(userAchievementIds, UserAchievementEntity.class, context);
    }

    @Named("integersToUserAchievementModels")
    default Set<UserAchievementModel> integersToUserAchievementModels(Set<Integer> userAchievementIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(userAchievementIds, UserAchievementModel.class, context);
    }

    @Named("userAchievementModelsToIntegers")
    default Set<Integer> userAchievementModelsToIntegers(Set<UserAchievementModel> userAchievementModels) {
        return MapperUtils.mapModelsToIntegers(userAchievementModels);
    }
}
