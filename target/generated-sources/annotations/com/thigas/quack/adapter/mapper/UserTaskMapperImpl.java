package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:33:27-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserTaskMapperImpl implements UserTaskMapper {

    @Override
    public UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUser( roadmapUserEntityUserId( roadmapUserEntity ) );
        userTaskDTO.setTask( roadmapUserEntityTaskId( roadmapUserEntity ) );
        userTaskDTO.setId( roadmapUserEntity.getId() );
        userTaskDTO.setImagePath( roadmapUserEntity.getImagePath() );
        userTaskDTO.setStatus( roadmapUserEntity.getStatus() );

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
        userTaskEntity.setImagePath( roadmapUserDTO.getImagePath() );
        userTaskEntity.setStatus( roadmapUserDTO.getStatus() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel entityToModel(UserTaskEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUser( userToModel( userEntityUserId( userEntity ) ) );
        userTaskModel.setTask( taskToModel( userEntityTaskId( userEntity ) ) );
        userTaskModel.setId( userEntity.getId() );
        userTaskModel.setImagePath( userEntity.getImagePath() );
        userTaskModel.setStatus( userEntity.getStatus() );

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
        userTaskEntity.setImagePath( userModel.getImagePath() );
        userTaskEntity.setStatus( userModel.getStatus() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel dtoToModel(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUser( userTaskDTOToUserModel( userTaskDTO ) );
        userTaskModel.setTask( userTaskDTOToTaskModel( userTaskDTO ) );
        userTaskModel.setId( userTaskDTO.getId() );
        userTaskModel.setImagePath( userTaskDTO.getImagePath() );
        userTaskModel.setStatus( userTaskDTO.getStatus() );

        return userTaskModel;
    }

    @Override
    public UserTaskDTO modelToDto(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUser( userTaskModelUserId( userTaskModel ) );
        userTaskDTO.setTask( userTaskModelTaskId( userTaskModel ) );
        userTaskDTO.setId( userTaskModel.getId() );
        userTaskDTO.setImagePath( userTaskModel.getImagePath() );
        userTaskDTO.setStatus( userTaskModel.getStatus() );

        return userTaskDTO;
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

        userEntity.setId( userTaskDTO.getUser() );

        return userEntity;
    }

    protected TaskEntity userTaskDTOToTaskEntity(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( userTaskDTO.getTask() );

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

        userEntity.setId( userModelToId( userTaskModel.getUser() ) );

        return userEntity;
    }

    protected TaskEntity userTaskModelToTaskEntity(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( taskModelToId( userTaskModel.getTask() ) );

        return taskEntity;
    }

    protected UserModel userTaskDTOToUserModel(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userTaskDTO.getUser() );

        return userModel;
    }

    protected TaskModel userTaskDTOToTaskModel(UserTaskDTO userTaskDTO) {
        if ( userTaskDTO == null ) {
            return null;
        }

        TaskModel taskModel = new TaskModel();

        taskModel.setId( userTaskDTO.getTask() );

        return taskModel;
    }

    private int userTaskModelUserId(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return 0;
        }
        UserModel user = userTaskModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userTaskModelTaskId(UserTaskModel userTaskModel) {
        if ( userTaskModel == null ) {
            return 0;
        }
        TaskModel task = userTaskModel.getTask();
        if ( task == null ) {
            return 0;
        }
        int id = task.getId();
        return id;
    }
}
