package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface LessonMapper {

    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepEntityToIntegers")
    LessonDTO entityToDto(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepEntityId")
    LessonEntity dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonModel entityToModel(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps")
    LessonEntity modelToEntity(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);


    @Mapping(source = "steps", target = "steps", qualifiedByName = "stepModelsToIntegers")
    LessonDTO modelToDto(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);

    @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepModels")
    LessonModel dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

}

