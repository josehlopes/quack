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
    date = "2024-10-03T01:18:06-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserTaskMapperImpl implements UserTaskMapper {

    @Override
    public UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity, CycleAvoidingMappingContext context) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUser( roadmapUserEntityUserId( roadmapUserEntity ) );
        userTaskDTO.setTask( roadmapUserEntityTaskId( roadmapUserEntity ) );
        userTaskDTO.setId( roadmapUserEntity.getId() );
        userTaskDTO.setStatus( roadmapUserEntity.getStatus() );
        userTaskDTO.setImagePath( roadmapUserEntity.getImagePath() );

        return userTaskDTO;
    }

    @Override
    public UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO, CycleAvoidingMappingContext context) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskDTOToUserEntity( roadmapUserDTO, context ) );
        userTaskEntity.setTask( userTaskDTOToTaskEntity( roadmapUserDTO, context ) );
        userTaskEntity.setId( roadmapUserDTO.getId() );
        userTaskEntity.setStatus( roadmapUserDTO.getStatus() );
        userTaskEntity.setImagePath( roadmapUserDTO.getImagePath() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel entityToModel(UserTaskEntity userEntity, CycleAvoidingMappingContext context) {
        if ( userEntity == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUser( userModelIdToInteger( userEntityUserId( userEntity ), context ) );
        userTaskModel.setTask( taskModelIdToInteger( userEntityTaskId( userEntity ), context ) );
        userTaskModel.setId( userEntity.getId() );
        userTaskModel.setStatus( userEntity.getStatus() );
        userTaskModel.setImagePath( userEntity.getImagePath() );

        return userTaskModel;
    }

    @Override
    public UserTaskEntity modelToEntity(UserTaskModel userModel, CycleAvoidingMappingContext context) {
        if ( userModel == null ) {
            return null;
        }

        UserTaskEntity userTaskEntity = new UserTaskEntity();

        userTaskEntity.setUser( userTaskModelToUserEntity( userModel, context ) );
        userTaskEntity.setTask( userTaskModelToTaskEntity( userModel, context ) );
        userTaskEntity.setId( userModel.getId() );
        userTaskEntity.setStatus( userModel.getStatus() );
        userTaskEntity.setImagePath( userModel.getImagePath() );

        return userTaskEntity;
    }

    @Override
    public UserTaskModel dtoToModel(UserTaskDTO userTaskDTO, CycleAvoidingMappingContext context) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserTaskModel userTaskModel = new UserTaskModel();

        userTaskModel.setUser( userTaskDTOToUserModel( userTaskDTO, context ) );
        userTaskModel.setTask( userTaskDTOToTaskModel( userTaskDTO, context ) );
        userTaskModel.setId( userTaskDTO.getId() );
        userTaskModel.setStatus( userTaskDTO.getStatus() );
        userTaskModel.setImagePath( userTaskDTO.getImagePath() );

        return userTaskModel;
    }

    @Override
    public UserTaskDTO modelToDto(UserTaskModel userTaskModel, CycleAvoidingMappingContext context) {
        if ( userTaskModel == null ) {
            return null;
        }

        UserTaskDTO userTaskDTO = new UserTaskDTO();

        userTaskDTO.setUser( userTaskModelUserId( userTaskModel ) );
        userTaskDTO.setTask( userTaskModelTaskId( userTaskModel ) );
        userTaskDTO.setId( userTaskModel.getId() );
        userTaskDTO.setStatus( userTaskModel.getStatus() );
        userTaskDTO.setImagePath( userTaskModel.getImagePath() );

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

    protected UserEntity userTaskDTOToUserEntity(UserTaskDTO userTaskDTO, CycleAvoidingMappingContext context) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userTaskDTO.getUser() );

        return userEntity;
    }

    protected TaskEntity userTaskDTOToTaskEntity(UserTaskDTO userTaskDTO, CycleAvoidingMappingContext context) {
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

    protected UserEntity userTaskModelToUserEntity(UserTaskModel userTaskModel, CycleAvoidingMappingContext context) {
        if ( userTaskModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( integerToUserModelId( userTaskModel.getUser() ) );

        return userEntity;
    }

    protected TaskEntity userTaskModelToTaskEntity(UserTaskModel userTaskModel, CycleAvoidingMappingContext context) {
        if ( userTaskModel == null ) {
            return null;
        }

        TaskEntity taskEntity = new TaskEntity();

        taskEntity.setId( integerToTaskModelId( userTaskModel.getTask() ) );

        return taskEntity;
    }

    protected UserModel userTaskDTOToUserModel(UserTaskDTO userTaskDTO, CycleAvoidingMappingContext context) {
        if ( userTaskDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userTaskDTO.getUser() );

        return userModel;
    }

    protected TaskModel userTaskDTOToTaskModel(UserTaskDTO userTaskDTO, CycleAvoidingMappingContext context) {
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
