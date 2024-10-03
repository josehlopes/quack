package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    @Mapping(target = "userAchievements", source = "userAchievements")
    AchievementEntity dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "userAchievements", source = "userAchievements")
    AchievementDTO entityToDto(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementModel entityToModel(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementEntity modelToEntity(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "userAchievements", source = "userAchievements")
    AchievementModel dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(target = "userAchievements", source = "userAchievements")
    AchievementDTO modelToDto(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    default Set<UserAchievementModel> integersToUserAchievementModelId(Set<Integer> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(achievements, UserAchievementModel.class, context);
    }

    default Set<Integer> userAchievementModelIdToIntegers(Set<UserAchievementModel> achievements) {
        return MapperUtils.modelsToIntegers(achievements);
    }

    default Set<UserAchievementEntity> integersToUserAchievementEntityId(Set<Integer> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(achievements, UserAchievementEntity.class, context);
    }

    default Set<Integer> userAchievementEntityToIntegers(Set<UserAchievementEntity> achievements) {
        return MapperUtils.entitiesToIntegers(achievements);
    }

    default OffsetDateTime offSetToString(String date) {
        if (date == null) {
            return null;
        }
        return OffsetDateTime.parse(date);
    }
}