package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:33:05-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public AchievementEntity dtoToEntity(AchievementDTO achievementDTO) {
        if ( achievementDTO == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setDescription( achievementDTO.getDescription() );
        achievementEntity.setId( achievementDTO.getId() );
        achievementEntity.setImagePath( achievementDTO.getImagePath() );
        achievementEntity.setName( achievementDTO.getName() );

        return achievementEntity;
    }

    @Override
    public AchievementDTO entityToDto(AchievementEntity achievementEntity) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementDTO achievementDTO = new AchievementDTO();

        achievementDTO.setDescription( achievementEntity.getDescription() );
        achievementDTO.setId( achievementEntity.getId() );
        achievementDTO.setImagePath( achievementEntity.getImagePath() );
        achievementDTO.setName( achievementEntity.getName() );

        return achievementDTO;
    }

    @Override
    public AchievementModel entityToModel(AchievementEntity achievementEntity) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setDescription( achievementEntity.getDescription() );
        achievementModel.setId( achievementEntity.getId() );
        achievementModel.setImagePath( achievementEntity.getImagePath() );
        achievementModel.setName( achievementEntity.getName() );

        return achievementModel;
    }

    @Override
    public AchievementEntity modelToEntity(AchievementModel achievementModel) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setDescription( achievementModel.getDescription() );
        achievementEntity.setId( achievementModel.getId() );
        achievementEntity.setImagePath( achievementModel.getImagePath() );
        achievementEntity.setName( achievementModel.getName() );

        return achievementEntity;
    }

    @Override
    public AchievementModel dtoToModel(AchievementDTO achievementDTO) {
        if ( achievementDTO == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setDescription( achievementDTO.getDescription() );
        achievementModel.setId( achievementDTO.getId() );
        achievementModel.setImagePath( achievementDTO.getImagePath() );
        achievementModel.setName( achievementDTO.getName() );

        return achievementModel;
    }

    @Override
    public AchievementDTO modelToDto(AchievementModel achievementModel) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementDTO achievementDTO = new AchievementDTO();

        achievementDTO.setDescription( achievementModel.getDescription() );
        achievementDTO.setId( achievementModel.getId() );
        achievementDTO.setImagePath( achievementModel.getImagePath() );
        achievementDTO.setName( achievementModel.getName() );

        return achievementDTO;
    }
}
