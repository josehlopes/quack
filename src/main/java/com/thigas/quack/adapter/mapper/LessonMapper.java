package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {MapperUtils.class, StepMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface LessonMapper  {

    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepEntityToIntegers")
    LessonDTO entityToDto(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepEntityId")
    LessonEntity dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonModel entityToModel(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonEntity modelToEntity(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);


    @Mapping(source = "steps",target = "steps", qualifiedByName = "stepModelsToIntegers")
    LessonDTO modelToDto(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps",target = "steps", qualifiedByName = "integersToStepModels")
    LessonModel dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);


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
}

