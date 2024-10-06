package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Autowired
    private StepMapper stepMapper;

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( stepMapper.stepEntityToIntegers( taskEntity.getSteps(), context ) );
        taskDTO.setId( taskEntity.getId() );
        taskDTO.setDescription( taskEntity.getDescription() );
        taskDTO.setImagePath( taskEntity.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskEntity dtoToEntity(TaskDTO taskDTO, CycleAvoidingMappingContext context) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setSteps( stepMapper.integersToStepEntityId( taskDTO.getSteps(), context ) );
        taskEntity.setId( taskDTO.getId() );
        taskEntity.setDescription( taskDTO.getDescription() );
        taskEntity.setImagePath( taskDTO.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel entityToModel(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setSteps( stepEntitySetToStepModelSet( taskEntity.getSteps(), context ) );
        taskModel.setId( taskEntity.getId() );
        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskEntity modelToEntity(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setSteps( stepModelSetToStepEntitySet( taskModel.getSteps(), context ) );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskDTO modelToDto(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( stepMapper.stepModelsToIntegers( taskModel.getSteps() ) );
        taskDTO.setId( taskModel.getId() );
        taskDTO.setDescription( taskModel.getDescription() );
        taskDTO.setImagePath( taskModel.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskModel dtoToModel(TaskDTO taskDTO, CycleAvoidingMappingContext context) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setSteps( stepMapper.integersToStepModels( taskDTO.getSteps(), context ) );
        taskModel.setId( taskDTO.getId() );
        taskModel.setDescription( taskDTO.getDescription() );
        taskModel.setImagePath( taskDTO.getImagePath() );

        return taskModel;
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
