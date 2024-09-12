package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

@Mapper
public interface AchievementMapper {

    AchievementMapper INSTANCE = Mappers.getMapper(AchievementMapper.class);

    AchievementEntity toAchievement(AchievementDTO achievementDTO);

    AchievementDTO toAchievementDTO(AchievementEntity achievementEntity);

    AchievementModel toAchievementModel(AchievementEntity achievementEntity);

    AchievementEntity toAchievement(AchievementModel achievementModel);
}