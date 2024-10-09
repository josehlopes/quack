package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.AchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class AchievementMapperImpl implements AchievementMapper {

    @Override
    public AchievementEntity dtoToEntity(AchievementDTO achievementDTO, CycleAvoidingMappingContext context) {
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
    public AchievementDTO entityToDto(AchievementEntity achievementEntity, CycleAvoidingMappingContext context) {
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
    public AchievementModel entityToModel(AchievementEntity achievementEntity, CycleAvoidingMappingContext context) {
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
    public AchievementEntity modelToEntity(AchievementModel achievementModel, CycleAvoidingMappingContext context) {
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
    public AchievementModel dtoToModel(AchievementDTO achievementDTO, CycleAvoidingMappingContext context) {
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
    public AchievementDTO modelToDto(AchievementModel achievementModel, CycleAvoidingMappingContext context) {
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
