package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StepMapper {

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepDTO entityToDto(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepEntity dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepModel entityToModel(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepEntity modelToEntity(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepModel dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepDTO modelToDto(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    default Set<RoadmapModel> integersToRoadmapModelId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(roadmaps, RoadmapModel.class, context);
    }

    default Set<Integer> roadmapModelIdToIntegers(Set<RoadmapModel> roadmaps) {
        return MapperUtils.modelsToIntegers(roadmaps);
    }

    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return  MapperUtils.integersToEntities(roadmaps, RoadmapEntity.class, context);
    }

    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(roadmaps);
    }

    default Set<LessonModel> integersToLessonModelId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
       return MapperUtils.integersToModels(lessons, LessonModel.class, context);
    }

    default Set<Integer> lessonModelToIntegers(Set<LessonModel> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.modelsToIntegers(lessons);
    }

    default Set<LessonEntity> integersToLessonEntityId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(lessons, LessonEntity.class, context);
    }

    default Set<Integer> lessonEntityToIntegers(Set<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(lessons);
    }

    default Set<TaskModel> integersToTaskModelId(Set<Integer> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(tasks, TaskModel.class, context);
    }

    default Set<Integer> taskModelToIntegers(Set<TaskModel> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.modelsToIntegers(tasks);
    }

    default Set<TaskEntity> integersToTaskEntityId(Set<Integer> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(tasks, TaskEntity.class, context);
    }

    default Set<Integer> taskEntityToIntegers(Set<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(tasks);
    }

    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }
}
