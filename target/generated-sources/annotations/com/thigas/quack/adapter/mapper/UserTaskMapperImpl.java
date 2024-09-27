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
    date = "2024-09-27T00:28:42-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserTaskMapperImpl implements UserTaskMapper {

    @Override
    public UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUserId( roadmapUserEntityUserId( roadmapUserEntity ) );
        userTaskDTO.setTaskId( roadmapUserEntityTaskId( roadmapUserEntity ) );
        userTaskDTO.setId( roadmapUserEntity.getId() );
        userTaskDTO.setStatus( roadmapUserEntity.getStatus() );
        userTaskDTO.setImagePath( roadmapUserEntity.getImagePath() );

        return userTaskDTO;
    }

    @Override
    public UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskDTOToUserEntity( roadmapUserDTO ) );
        userTaskEntity.setTask( userTaskDTOToTaskEntity( roadmapUserDTO ) );
        userTaskEntity.setId( roadmapUserDTO.getId() );
        userTaskEntity.setStatus( roadmapUserDTO.getStatus() );
        userTaskEntity.setImagePath( roadmapUserDTO.getImagePath() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel entityToModel(UserTaskEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUserId( userIdToModel( userEntityUserId( userEntity ) ) );
        userTaskModel.setTaskId( taskIdToModel( userEntityTaskId( userEntity ) ) );
        userTaskModel.setId( userEntity.getId() );
        userTaskModel.setStatus( userEntity.getStatus() );
        userTaskModel.setImagePath( userEntity.getImagePath() );

        return userTaskModel;
    }

    @Override
    public UserTaskEntity modelToEntity(UserTaskModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskModelToUserEntity( userModel ) );
        userTaskEntity.setTask( userTaskModelToTaskEntity( userModel ) );
        userTaskEntity.setId( userModel.getId() );
        userTaskEntity.setStatus( userModel.getStatus() );
        userTaskEntity.setImagePath( userModel.getImagePath() );

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
