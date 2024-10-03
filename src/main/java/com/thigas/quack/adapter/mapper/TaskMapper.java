package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "steps", target = "steps")
    TaskDTO entityToDto(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskEntity dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskModel entityToModel(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskEntity modelToEntity(TaskModel taskModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskModel dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskDTO modelToDto(TaskModel taskModel, @Context CycleAvoidingMappingContext context);

    default Set<Integer> taskEntityToIntegers(Set<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(tasks);
    }

    default Set<TaskEntity> integersToTaskEntityId(Set<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(tasksIds, TaskEntity.class, context);
    }

    default Set<Integer> stepEntityToIntegers(Set<StepEntity> steps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(steps);
    }

    default Set<StepEntity> integersToStepEntityId(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(stepIds, StepEntity.class, context);
    }

    default Set<StepModel> integersToStepModels(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(stepIds, StepModel.class, context);
    }

    default Set<Integer> stepModelsToIntegers(Set<StepModel> stepModels) {
        return MapperUtils.modelsToIntegers(stepModels);
    }
}
