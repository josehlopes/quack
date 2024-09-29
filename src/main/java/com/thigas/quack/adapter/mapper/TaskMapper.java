package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
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

    default List<Integer> taskEntityToIntegers(List<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(tasks);
    }

    default List<TaskEntity> integersToTaskEntityId(List<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(tasksIds, TaskEntity.class, context);
    }

    default List<Integer> stepEntityToIntegers(List<StepEntity> steps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(steps);
    }

    default List<StepEntity> integersToStepEntityId(List<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(stepIds, StepEntity.class, context);
    }

    default List<StepModel> integersToStepModels(List<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(stepIds, StepModel.class, context);
    }

    default List<Integer> stepModelsToIntegers(List<StepModel> stepModels) {
        return MapperUtils.modelsToIntegers(stepModels);
    }
}
