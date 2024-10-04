package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-03T22:41:53-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity, CycleAvoidingMappingContext context) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( stepEntityToIntegers( taskEntity.getSteps(), context ) );
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

        taskEntity.setSteps( integersToStepEntityId( taskDTO.getSteps(), context ) );
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

        taskModel.setSteps( integersToStepModels( stepEntityToIntegers( taskEntity.getSteps(), context ), context ) );
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

        taskEntity.setSteps( integersToStepEntityId( stepModelsToIntegers( taskModel.getSteps() ), context ) );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel dtoToModel(TaskDTO taskDTO, CycleAvoidingMappingContext context) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setSteps( integersToStepModels( taskDTO.getSteps(), context ) );
        taskModel.setId( taskDTO.getId() );
        taskModel.setDescription( taskDTO.getDescription() );
        taskModel.setImagePath( taskDTO.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskDTO modelToDto(TaskModel taskModel, CycleAvoidingMappingContext context) {
        if ( taskModel == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setSteps( stepModelsToIntegers( taskModel.getSteps() ) );
        taskDTO.setId( taskModel.getId() );
        taskDTO.setDescription( taskModel.getDescription() );
        taskDTO.setImagePath( taskModel.getImagePath() );

        return taskDTO;
    }
}
