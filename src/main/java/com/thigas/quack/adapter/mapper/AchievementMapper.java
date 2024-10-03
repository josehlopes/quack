package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    AchievementEntity dtoToEntity(AchievementDTO achievementDTO);

    AchievementDTO entityToDto(AchievementEntity achievementEntity);

    AchievementModel entityToModel(AchievementEntity achievementEntity);

    AchievementEntity modelToEntity(AchievementModel achievementModel);

    AchievementModel dtoToModel(AchievementDTO achievementDTO);

    AchievementDTO modelToDto(AchievementModel achievementModel);
}