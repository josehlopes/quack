package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

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

    default List<Integer> lessonEntityToIntegers(List<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(lessons);
    }

    default List<LessonEntity> integersToLessonEntityId(List<Integer> lessonIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(lessonIds, LessonEntity.class, context);
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

