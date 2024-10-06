package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.*;

import java.util.Set;

@Mapper(uses = {RoadmapMapper.class, LessonMapper.class, TaskMapper.class}, componentModel = "spring")
public interface StepMapper {


    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "roadmapEntityToIntegers"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "lessonEntityToIntegers"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "taskEntityToIntegers")
    })
    StepDTO entityToDto(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "integersToRoadmapEntityId"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "integersToLessonEntityId"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "integersToTaskEntityId")
    })
    StepEntity dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);


    StepModel entityToModel(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    StepEntity modelToEntity(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "integersToRoadmapModelId"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "integersToLessonModelId"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "integersToTaskModelId")
    })
    StepModel dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "roadmapModelToIntegers"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "lessonModelToIntegers"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "taskModelToIntegers")
    })
    StepDTO modelToDto(StepModel stepModel, @Context CycleAvoidingMappingContext context);


    @Named("stepEntityToIntegers")
    default Set<Integer> stepEntityToIntegers(Set<StepEntity> steps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(steps);
    }

    @Named("integersToStepEntityId")
    default Set<StepEntity> integersToStepEntityId(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(stepIds, StepEntity.class, context);
    }

    @Named("integersToStepModels")
    default Set<StepModel> integersToStepModels(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(stepIds, StepModel.class, context);
    }

    @Named("stepModelsToIntegers")
    default Set<Integer> stepModelsToIntegers(Set<StepModel> stepModels) {
        return MapperUtils.mapModelsToIntegers(stepModels);
    }

    @Named("integerToStatusValue")
    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    @Named("statusValueToInteger")
    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }
}
