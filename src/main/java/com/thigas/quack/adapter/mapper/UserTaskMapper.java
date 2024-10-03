package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserMapper.class, TaskMapper.class}, componentModel = "spring")
public interface UserTaskMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskModel entityToModel(UserTaskEntity userEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskEntity modelToEntity(UserTaskModel userModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskModel dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskDTO modelToDto(UserTaskModel userTaskModel, @Context CycleAvoidingMappingContext context);

    default UserModel userModelIdToInteger(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToModel(user, UserModel.class, context);
    }

    default Integer integerToUserModelId(UserModel userModel) {
        return MapperUtils.modelToInteger(userModel);
    }

    default TaskModel taskModelIdToInteger(Integer task, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToModel(task, TaskModel.class, context);
    }

    default Integer integerToTaskModelId(TaskModel taskModel) {
        return MapperUtils.modelToInteger(taskModel);
    }
}