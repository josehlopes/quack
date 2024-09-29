package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-29T20:23:02-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public AchievementEntity dtoToEntity(AchievementDTO achievementDTO) {
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
    public AchievementDTO entityToDto(AchievementEntity achievementEntity) {
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
    public AchievementModel entityToModel(AchievementEntity achievementEntity) {
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
    public AchievementEntity modelToEntity(AchievementModel achievementModel) {
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

    @Override
    public AchievementModel dtoToModel(AchievementDTO achievementDTO) {
        if ( achievementDTO == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( achievementDTO.getId() );
        achievementModel.setName( achievementDTO.getName() );
        achievementModel.setDescription( achievementDTO.getDescription() );
        achievementModel.setImagePath( achievementDTO.getImagePath() );

        return achievementModel;
    }

    @Override
    public AchievementDTO modelToDto(AchievementModel achievementModel) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementDTO achievementDTO = new AchievementDTO();

        achievementDTO.setId( achievementModel.getId() );
        achievementDTO.setName( achievementModel.getName() );
        achievementDTO.setDescription( achievementModel.getDescription() );
        achievementDTO.setImagePath( achievementModel.getImagePath() );

        return achievementDTO;
    }
}
