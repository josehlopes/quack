package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DefaultMapper.class, injectionStrategy = InjectionStrategy.FIELD)
public interface AchievementMapper {

    AchievementEntity dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO entityToDto(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementModel entityToModel(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);

    AchievementEntity modelToEntity(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    AchievementModel dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO modelToDto(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);


}