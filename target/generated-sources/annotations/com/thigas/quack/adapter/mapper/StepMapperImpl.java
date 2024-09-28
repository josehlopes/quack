package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:33:30-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class StepMapperImpl implements StepMapper {

    @Override
    public StepDTO entityToDto(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapsToIds( stepEntity.getRoadmaps() ) );
        stepDTO.setStatus( statusToInt( stepEntity.getStatus() ) );
        stepDTO.setDescription( stepEntity.getDescription() );
        stepDTO.setId( stepEntity.getId() );
        stepDTO.setImagePath( stepEntity.getImagePath() );

        return stepDTO;
    }

    @Override
    public StepEntity dtoToEntity(StepDTO stepDTO) {
        if ( stepDTO == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setRoadmaps( idsToRoadmaps( stepDTO.getRoadmaps() ) );
        stepEntity.setStatus( intToStatus( stepDTO.getStatus() ) );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setImagePath( stepDTO.getImagePath() );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setDescription( stepEntity.getDescription() );
        stepModel.setId( stepEntity.getId() );
        stepModel.setImagePath( stepEntity.getImagePath() );
        stepModel.setStatus( stepEntity.getStatus() );

        return stepModel;
    }

    @Override
    public StepEntity modelToEntity(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepEntity stepEntity = new StepEntity();

        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setId( stepModel.getId() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }

    @Override
    public StepModel dtoToModel(StepDTO stepDTO) {
        if ( stepDTO == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setRoadmaps( idsToRoadmapsModel( stepDTO.getRoadmaps() ) );
        stepModel.setStatus( intToStatus( stepDTO.getStatus() ) );
        stepModel.setDescription( stepDTO.getDescription() );
        stepModel.setId( stepDTO.getId() );
        stepModel.setImagePath( stepDTO.getImagePath() );

        return stepModel;
    }

    @Override
    public StepDTO modelToDto(StepModel stepModel) {
        if ( stepModel == null ) {
            return null;
        }

        StepDTO stepDTO = new StepDTO();

        stepDTO.setRoadmaps( roadmapsToIdsModel( stepModel.getRoadmaps() ) );
        stepDTO.setStatus( statusToInt( stepModel.getStatus() ) );
        stepDTO.setDescription( stepModel.getDescription() );
        stepDTO.setId( stepModel.getId() );
        stepDTO.setImagePath( stepModel.getImagePath() );

        return stepDTO;
    }
}
