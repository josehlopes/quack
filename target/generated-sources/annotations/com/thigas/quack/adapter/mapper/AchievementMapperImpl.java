package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:59:35-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public AchievementEntity toAchievement(AchievementDTO achievementDTO) {
        if ( achievementDTO == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( achievementDTO.getId() );
        achievementEntity.setName( achievementDTO.getName() );
        achievementEntity.setDescription( achievementDTO.getDescription() );
        achievementEntity.setImagePath( achievementDTO.getImagePath() );

        return achievementEntity;
    }

    @Override
    public AchievementDTO toAchievementDTO(AchievementEntity achievementEntity) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementDTO achievementDTO = new AchievementDTO();

        achievementDTO.setId( achievementEntity.getId() );
        achievementDTO.setName( achievementEntity.getName() );
        achievementDTO.setDescription( achievementEntity.getDescription() );
        achievementDTO.setImagePath( achievementEntity.getImagePath() );

        return achievementDTO;
    }

    @Override
    public AchievementModel toAchievementModel(AchievementEntity achievementEntity) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( achievementEntity.getId() );
        achievementModel.setName( achievementEntity.getName() );
        achievementModel.setDescription( achievementEntity.getDescription() );
        achievementModel.setImagePath( achievementEntity.getImagePath() );

        return achievementModel;
    }

    @Override
    public AchievementEntity toAchievement(AchievementModel achievementModel) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( achievementModel.getId() );
        achievementEntity.setName( achievementModel.getName() );
        achievementEntity.setDescription( achievementModel.getDescription() );
        achievementEntity.setImagePath( achievementModel.getImagePath() );

        return achievementEntity;
    }
}
