package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {MapperUtils.class, StepMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface TaskMapper {

    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepEntityToIntegers")
    TaskDTO entityToDto(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps",target = "steps", qualifiedByName = "integersToStepEntityId")
    TaskEntity dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskModel entityToModel(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    TaskEntity modelToEntity(TaskModel taskModel, @Context CycleAvoidingMappingContext context);


    @Mapping(source = "steps",target = "steps", qualifiedByName = "stepModelsToIntegers")
    TaskDTO modelToDto(TaskModel taskModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps",target = "steps", qualifiedByName = "integersToStepModels")
    TaskModel dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);


    @Named("taskEntityToIntegers")
    default Set<Integer> taskEntityToIntegers(Set<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(tasks);
    }

    @Named("integersToTaskEntityId")
    default Set<TaskEntity> integersToTaskEntityId(Set<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(tasksIds, TaskEntity.class, context);
    }

    @Named("taskModelToIntegers")
    default Set<Integer> taskModelToIntegers(Set<TaskModel> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(tasks);
    }

    @Named("integersToTaskModelId")
    default Set<TaskModel> integersToTaskModelId(Set<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(tasksIds, TaskModel.class, context);
    }


}
