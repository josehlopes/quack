package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T11:57:34-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserTaskMapperImpl implements UserTaskMapper {

    @Override
    public UserTaskDTO EntityToDto(UserTaskEntity roadmapUserEntity) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUserId( roadmapUserEntityUserId( roadmapUserEntity ) );
        userTaskDTO.setTaskId( roadmapUserEntityTaskId( roadmapUserEntity ) );
        userTaskDTO.setStatus( roadmapUserEntity.getStatus() );
        userTaskDTO.setImagePath( roadmapUserEntity.getImagePath() );
        userTaskDTO.setId( roadmapUserEntity.getId() );

        return userTaskDTO;
    }

    @Override
    public UserTaskEntity DtoToEntity(UserTaskDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskDTOToUserEntity( roadmapUserDTO ) );
        userTaskEntity.setTask( userTaskDTOToTaskEntity( roadmapUserDTO ) );
        userTaskEntity.setStatus( roadmapUserDTO.getStatus() );
        userTaskEntity.setImagePath( roadmapUserDTO.getImagePath() );
        userTaskEntity.setId( roadmapUserDTO.getId() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel EntityToModel(UserTaskEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUserId( userIdToModel( userEntityUserId( userEntity ) ) );
        userTaskModel.setTaskId( taskIdToModel( userEntityTaskId( userEntity ) ) );
        userTaskModel.setStatus( userEntity.getStatus() );
        userTaskModel.setImagePath( userEntity.getImagePath() );
        userTaskModel.setId( userEntity.getId() );

        return userTaskModel;
    }

    @Override
    public UserTaskEntity ModelToEntity(UserTaskModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskModelToUserEntity( userModel ) );
        userTaskEntity.setTask( userTaskModelToTaskEntity( userModel ) );
        userTaskEntity.setStatus( userModel.getStatus() );
        userTaskEntity.setImagePath( userModel.getImagePath() );
        userTaskEntity.setId( userModel.getId() );

        return userTaskEntity;
    }

    private int roadmapUserEntityUserId(UserTaskEntity userTaskEntity) {
        if ( userTaskEntity == null ) {
            return 0;
        }
        UserEntity user = userTaskEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int roadmapUserEntityTaskId(UserTaskEntity userTaskEntity) {
        if ( userTaskEntity == null ) {
            return 0;
        }
        TaskEntity task = userTaskEntity.getTask();
        if ( task == null ) {
            return 0;
        }
        int id = task.getId();
        return id;
    }

    protected UserEntity userTaskDTOToUserEntity(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userTaskDTO.getUserId() );

        return userEntity;
    }

    protected TaskEntity userTaskDTOToTaskEntity(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( userTaskDTO.getTaskId() );

        return taskEntity;
    }

    private Integer userEntityUserId(UserTaskEntity userTaskEntity) {
        if ( userTaskEntity == null ) {
            return null;
        }
        UserEntity user = userTaskEntity.getUser();
        if ( user == null ) {
            return null;
        }
        int id = user.getId();
        return id;
    }

    private Integer userEntityTaskId(UserTaskEntity userTaskEntity) {
        if ( userTaskEntity == null ) {
            return null;
        }
        TaskEntity task = userTaskEntity.getTask();
        if ( task == null ) {
            return null;
        }
        int id = task.getId();
        return id;
    }

    protected UserEntity userTaskModelToUserEntity(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModelToId( userTaskModel.getUserId() ) );

        return userEntity;
    }

    protected TaskEntity userTaskModelToTaskEntity(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( taskModelToId( userTaskModel.getTaskId() ) );

        return taskEntity;
    }
}
