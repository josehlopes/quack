package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;

@Mapper
public interface AchievementMapper {

    AchievementMapper INSTANCE = Mappers.getMapper(AchievementMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    AchievementEntity DtoToEntity(AchievementDTO achievementDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    AchievementDTO EntityToDto(AchievementEntity achievementEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    AchievementModel EntityToModel(AchievementEntity achievementEntity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "imagePath", target = "imagePath")
    AchievementEntity ModelToEntity(AchievementModel achievementModel);
}