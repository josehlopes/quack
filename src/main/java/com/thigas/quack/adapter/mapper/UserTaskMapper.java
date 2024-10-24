package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserTaskDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserTaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserTaskMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")
    })
    UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);

    UserTaskModel entityToModel(UserTaskEntity userEntity, @Context CycleAvoidingMappingContext context);

    UserTaskEntity modelToEntity(UserTaskModel userModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "task", target = "task.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserTaskModel dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "task.id", target = "task"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")})
    UserTaskDTO modelToDto(UserTaskModel userTaskModel, @Context CycleAvoidingMappingContext context);

}