package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    AchievementEntity dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO entityToDto(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementModel entityToModel(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementEntity modelToEntity(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    AchievementModel dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO modelToDto(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    @Named("integerToAchievementModel")
    default AchievementModel integerToAchievementModel(Integer user) {
        if (user == null) {
            return null;
        }
        AchievementModel achievementModel = new AchievementModel();
        achievementModel.setId(user);
        return achievementModel;
    }

    @Named("achievementModelToInteger")
    default Integer achievementModelToInteger(AchievementModel achievementModel) {
        if (achievementModel == null) {
            return null;
        }
        return achievementModel.getId();
    }

    @Named("integerToAchievementEntity")
    default AchievementEntity integerToAchievementEntity(Integer achievement) {
        if (achievement == null) {
            return null;
        }
        AchievementEntity achievementEntity = new AchievementEntity();
        achievementEntity.setId(achievement);
        return achievementEntity;
    }

    @Named("achievementEntityToInteger")
    default Integer achievementEntityToInteger(AchievementEntity achievementEntity) {
        if (achievementEntity == null) {
            return null;
        }
        return achievementEntity.getId();
    }
}