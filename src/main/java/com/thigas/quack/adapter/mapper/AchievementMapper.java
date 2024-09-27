package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    AchievementMapper INSTANCE = Mappers.getMapper(AchievementMapper.class);

    AchievementEntity dtoToEntity(AchievementDTO achievementDTO);

    AchievementDTO entityToDto(AchievementEntity achievementEntity);

    AchievementModel entityToModel(AchievementEntity achievementEntity);

    AchievementEntity modelToEntity(AchievementModel achievementModel);
}