package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-27T22:10:00-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
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
        stepDTO.setId( stepEntity.getId() );
        stepDTO.setDescription( stepEntity.getDescription() );
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
        stepEntity.setId( stepDTO.getId() );
        stepEntity.setDescription( stepDTO.getDescription() );
        stepEntity.setImagePath( stepDTO.getImagePath() );

        return stepEntity;
    }

    @Override
    public StepModel entityToModel(StepEntity stepEntity) {
        if ( stepEntity == null ) {
            return null;
        }

        StepModel stepModel = new StepModel();

        stepModel.setId( stepEntity.getId() );
        stepModel.setDescription( stepEntity.getDescription() );
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

        stepEntity.setId( stepModel.getId() );
        stepEntity.setDescription( stepModel.getDescription() );
        stepEntity.setImagePath( stepModel.getImagePath() );
        stepEntity.setStatus( stepModel.getStatus() );

        return stepEntity;
    }
}
