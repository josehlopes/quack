package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserMapper.class, TaskMapper.class}, componentModel = "spring")
public interface UserTaskMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskModel entityToModel(UserTaskEntity userEntity);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskEntity modelToEntity(UserTaskModel userModel);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskModel dtoToModel(UserTaskDTO userTaskDTO);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskDTO modelToDto(UserTaskModel userTaskModel);

    default UserModel userToModel(Integer user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(user);
        return userModel;
    }

    default Integer userModelToId(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    default TaskModel taskToModel(Integer task) {
        if (task == null) {
            return null;
        }
        TaskModel taskModel = new TaskModel();
        taskModel.setId(task);
        return taskModel;
    }

    default Integer taskModelToId(TaskModel taskModel) {
        if (taskModel == null) {
            return null;
        }
        return taskModel.getId();
    }
}