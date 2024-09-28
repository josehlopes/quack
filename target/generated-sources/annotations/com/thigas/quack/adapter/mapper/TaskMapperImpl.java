package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:33:24-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public TaskDTO entityToDto(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setDescription( taskEntity.getDescription() );
        taskDTO.setId( taskEntity.getId() );
        taskDTO.setImagePath( taskEntity.getImagePath() );

        return taskDTO;
    }

    @Override
    public TaskEntity dtoToEntity(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setDescription( taskDTO.getDescription() );
        taskEntity.setId( taskDTO.getId() );
        taskEntity.setImagePath( taskDTO.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel entityToModel(TaskEntity taskEntity) {
        if ( taskEntity == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setDescription( taskEntity.getDescription() );
        taskModel.setId( taskEntity.getId() );
        taskModel.setImagePath( taskEntity.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskEntity modelToEntity(TaskModel taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setDescription( taskModel.getDescription() );
        taskEntity.setId( taskModel.getId() );
        taskEntity.setImagePath( taskModel.getImagePath() );

        return taskEntity;
    }

    @Override
    public TaskModel dtoToModel(TaskDTO taskDTO) {
        if ( taskDTO == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setDescription( taskDTO.getDescription() );
        taskModel.setId( taskDTO.getId() );
        taskModel.setImagePath( taskDTO.getImagePath() );

        return taskModel;
    }

    @Override
    public TaskDTO modelToDto(TaskModel taskModel) {
        if ( taskModel == null ) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setDescription( taskModel.getDescription() );
        taskDTO.setId( taskModel.getId() );
        taskDTO.setImagePath( taskModel.getImagePath() );

        return taskDTO;
    }
}
