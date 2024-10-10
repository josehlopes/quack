package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserTaskMapper {

    @Mappings({@Mapping(target = "user", qualifiedByName = "userEntityToInteger"),
            @Mapping(target = "task", qualifiedByName = "taskEntityToInteger")})
    UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(target = "user.id", qualifiedByName = "userIntegerToEntity"),
            @Mapping(target = "task.id", qualifiedByName = "integerToTaskEntity")})
    UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task")})
    UserTaskModel entityToModel(UserTaskEntity userEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id")})
    UserTaskEntity modelToEntity(UserTaskModel userModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(target = "user.id", qualifiedByName = "integerToUserModel"),
            @Mapping(target = "task.id", qualifiedByName = "integerToTaskModel")})
    UserTaskModel dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(target = "user", qualifiedByName = "userModelToInteger"),
            @Mapping(target = "task", qualifiedByName = "taskModelToInteger")})
    UserTaskDTO modelToDto(UserTaskModel userTaskModel, @Context CycleAvoidingMappingContext context);

}