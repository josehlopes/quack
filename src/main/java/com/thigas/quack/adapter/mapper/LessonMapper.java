package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mapping(source = "steps", target = "steps")
    LessonDTO entityToDto(LessonEntity lesson, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonEntity dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    LessonEntity modelToEntity(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);

    LessonModel entityToModel(LessonEntity lesson, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonModel dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonDTO modelToDto(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);

    default Set<Integer> lessonEntityToIntegers(Set<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(lessons);
    }

    default Set<LessonEntity> integersToLessonEntityId(Set<Integer> lessonIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(lessonIds, LessonEntity.class, context);
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

