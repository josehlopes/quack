package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-05T18:22:48-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class RoadmapMapperImpl implements RoadmapMapper {

    @Override
    public RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, CycleAvoidingMappingContext context) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusValueToInteger( roadmapEntity.getStatus() ) );
        roadmapDTO.setSteps( stepEntityToIntegers( roadmapEntity.getSteps(), context ) );
        roadmapDTO.setId( roadmapEntity.getId() );
        roadmapDTO.setTitle( roadmapEntity.getTitle() );
        roadmapDTO.setDescription( roadmapEntity.getDescription() );
        roadmapDTO.setImagePath( roadmapEntity.getImagePath() );

        return roadmapDTO;
    }

    @Override
    public RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO, CycleAvoidingMappingContext context) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setStatus( integerToStatusValue( roadmapDTO.getStatus() ) );
        roadmapEntity.setSteps( integersToStepEntityId( roadmapDTO.getSteps(), context ) );
        roadmapEntity.setId( roadmapDTO.getId() );
        roadmapEntity.setTitle( roadmapDTO.getTitle() );
        roadmapEntity.setDescription( roadmapDTO.getDescription() );
        roadmapEntity.setImagePath( roadmapDTO.getImagePath() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel entityToModel(RoadmapEntity roadmapEntity, CycleAvoidingMappingContext context) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setStatus( roadmapEntity.getStatus() );
        roadmapModel.setSteps( integersToStepModels( stepEntityToIntegers( roadmapEntity.getSteps(), context ), context ) );
        roadmapModel.setId( roadmapEntity.getId() );
        roadmapModel.setTitle( roadmapEntity.getTitle() );
        roadmapModel.setDescription( roadmapEntity.getDescription() );
        roadmapModel.setImagePath( roadmapEntity.getImagePath() );

        return roadmapModel;
    }

    @Override
    public RoadmapEntity modelToEntity(RoadmapModel roadmapModel, CycleAvoidingMappingContext context) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setStatus( roadmapModel.getStatus() );
        roadmapEntity.setSteps( integersToStepEntityId( stepModelsToIntegers( roadmapModel.getSteps() ), context ) );
        roadmapEntity.setId( roadmapModel.getId() );
        roadmapEntity.setTitle( roadmapModel.getTitle() );
        roadmapEntity.setDescription( roadmapModel.getDescription() );
        roadmapEntity.setImagePath( roadmapModel.getImagePath() );

        return roadmapEntity;
    }

    @Override
    public RoadmapModel dtoToModel(RoadmapDTO roadmapDTO, CycleAvoidingMappingContext context) {
        if ( roadmapDTO == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setStatus( integerToStatusValue( roadmapDTO.getStatus() ) );
        roadmapModel.setSteps( integersToStepModels( roadmapDTO.getSteps(), context ) );
        roadmapModel.setId( roadmapDTO.getId() );
        roadmapModel.setTitle( roadmapDTO.getTitle() );
        roadmapModel.setDescription( roadmapDTO.getDescription() );
        roadmapModel.setImagePath( roadmapDTO.getImagePath() );

        return roadmapModel;
    }

    @Override
    public RoadmapDTO modelToDto(RoadmapModel roadmapModel, CycleAvoidingMappingContext context) {
        if ( roadmapModel == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusValueToInteger( roadmapModel.getStatus() ) );
        roadmapDTO.setSteps( stepModelsToIntegers( roadmapModel.getSteps() ) );
        roadmapDTO.setId( roadmapModel.getId() );
        roadmapDTO.setTitle( roadmapModel.getTitle() );
        roadmapDTO.setDescription( roadmapModel.getDescription() );
        roadmapDTO.setImagePath( roadmapModel.getImagePath() );

        return roadmapDTO;
    }
}
