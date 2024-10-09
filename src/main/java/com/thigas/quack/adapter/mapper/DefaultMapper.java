package com.thigas.quack.adapter.mapper;

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
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface DefaultMapper {
    @Named("integersToRoadmapEntityId")
    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(roadmaps, RoadmapEntity.class, context);
    }

    @Named("roadmapEntityToIntegers")
    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(roadmaps);
    }

    @Named("integersToRoadmapModelId")
    default Set<RoadmapModel> integersToRoadmapModelId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(roadmaps, RoadmapModel.class, context);
    }

    @Named("roadmapModelToIntegers")
    default Set<Integer> roadmapModelToIntegers(Set<RoadmapModel> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(roadmaps);
    }

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


    @Named("integerToRoadmapModel")
    default RoadmapModel integerToRoadmapModel(Integer roadmap) {
        if (roadmap == null) {
            return null;
        }
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap);
        return roadmapModel;
    }

    @Named("roadmapModelToInteger")
    default Integer roadmapModelToInteger(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            return null;
        }
        return roadmapModel.getId();
    }

    @Named("integerToRoadmapEntity")
    default RoadmapEntity integerToRoadmapEntity(Integer roadmap) {
        if (roadmap == null) {
            return null;
        }
        RoadmapEntity roadmapEntity = new RoadmapEntity();
        roadmapEntity.setId(roadmap);
        return roadmapEntity;
    }

    @Named("roadmapEntityToInteger")
    default Integer roadmapEntityToInteger(RoadmapEntity roadmapEntity) {
        if (roadmapEntity == null) {
            return null;
        }
        return roadmapEntity.getId();
    }

    @Named("integersToLessonModelId")
    default Set<LessonModel> integersToLessonModelId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(lessons, LessonModel.class, context);
    }

    @Named("lessonModelToIntegers")
    default Set<Integer> lessonModelToIntegers(Set<LessonModel> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(lessons);
    }

    @Named("integersToLessonEntityId")
    default Set<LessonEntity> integersToLessonEntityId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(lessons, LessonEntity.class, context);
    }

    @Named("lessonEntityToIntegers")
    default Set<Integer> lessonEntityToIntegers(Set<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(lessons);
    }

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
