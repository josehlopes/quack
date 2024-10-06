package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class RoadmapMapperImpl implements RoadmapMapper {

    @Autowired
    private StepMapper stepMapper;

    @Override
    public RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, CycleAvoidingMappingContext context) {
        if ( roadmapEntity == null ) {
            return null;
        }

        RoadmapDTO roadmapDTO = new RoadmapDTO();

        roadmapDTO.setStatus( statusValueToInteger( roadmapEntity.getStatus() ) );
        roadmapDTO.setSteps( stepMapper.stepEntityToIntegers( roadmapEntity.getSteps(), context ) );
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
        roadmapEntity.setSteps( stepMapper.integersToStepEntityId( roadmapDTO.getSteps(), context ) );
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
        roadmapModel.setSteps( stepEntitySetToStepModelSet( roadmapEntity.getSteps(), context ) );
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
        roadmapEntity.setSteps( stepModelSetToStepEntitySet( roadmapModel.getSteps(), context ) );
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
        roadmapModel.setSteps( stepMapper.integersToStepModels( roadmapDTO.getSteps(), context ) );
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
        roadmapDTO.setSteps( stepMapper.stepModelsToIntegers( roadmapModel.getSteps() ) );
        roadmapDTO.setId( roadmapModel.getId() );
        roadmapDTO.setTitle( roadmapModel.getTitle() );
        roadmapDTO.setDescription( roadmapModel.getDescription() );
        roadmapDTO.setImagePath( roadmapModel.getImagePath() );

        return roadmapDTO;
    }

    protected Set<StepModel> stepEntitySetToStepModelSet(Set<StepEntity> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepModel> set1 = new LinkedHashSet<StepModel>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepEntity stepEntity : set ) {
            set1.add( stepMapper.entityToModel( stepEntity, context ) );
        }

        return set1;
    }

    protected Set<StepEntity> stepModelSetToStepEntitySet(Set<StepModel> set, CycleAvoidingMappingContext context) {
        if ( set == null ) {
            return null;
        }

        Set<StepEntity> set1 = new LinkedHashSet<StepEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StepModel stepModel : set ) {
            set1.add( stepMapper.modelToEntity( stepModel, context ) );
        }

        return set1;
    }
}
