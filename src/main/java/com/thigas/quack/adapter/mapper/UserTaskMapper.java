package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserMapper.class, TaskMapper.class}, componentModel = "spring")
public interface UserTaskMapper {

    UserTaskMapper INSTANCE = Mappers.getMapper(UserTaskMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "imagePath", target = "imagePath")
    UserTaskDTO EntityToDto(UserTaskEntity roadmapUserEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "taskId", target = "task.id")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "imagePath", target = "imagePath")
    UserTaskEntity DtoToEntity(UserTaskDTO roadmapUserDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "task.id", target = "taskId")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "imagePath", target = "imagePath")
    UserTaskModel EntityToModel(UserTaskEntity userEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "taskId", target = "task.id")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "imagePath", target = "imagePath")
    UserTaskEntity ModelToEntity(UserTaskModel userModel);

    default UserModel userIdToModel(Integer userId) {
        if (userId == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        return userModel;
    }

    default Integer userModelToId(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    default TaskModel taskIdToModel(Integer taskId) {
        if (taskId == null) {
            return null;
        }
        TaskModel taskModel = new TaskModel();
        taskModel.setId(taskId);
        return taskModel;
    }

    default Integer taskModelToId(TaskModel taskModel) {
        if (taskModel == null) {
            return null;
        }
        return taskModel.getId();
    }
}