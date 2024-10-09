package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring" , uses = {DefaultMapper.class})
public interface TaskMapper {

    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepEntityToIntegers")
    TaskDTO entityToDto(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepEntityId")
    TaskEntity dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskModel entityToModel(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskEntity modelToEntity(TaskModel taskModel, @Context CycleAvoidingMappingContext context);


    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepModelsToIntegers")
    TaskDTO modelToDto(TaskModel taskModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepModels")
    TaskModel dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);





}
