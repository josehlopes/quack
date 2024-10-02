package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AchievementMapper {

    @Mapping(source = "userAchievements", target = "userAchievements")
    AchievementEntity dtoToEntity(AchievementDTO achievementDTO);

    AchievementDTO entityToDto(AchievementEntity achievementEntity);

    AchievementModel entityToModel(AchievementEntity achievementEntity);

    AchievementEntity modelToEntity(AchievementModel achievementModel);

    @Mapping(source = "userAchievements", target = "userAchievements")
    AchievementModel dtoToModel(AchievementDTO achievementDTO);

    AchievementDTO modelToDto(AchievementModel achievementModel);
}