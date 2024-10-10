package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface StepMapper {
    // Métodos de mapeamento usando os métodos de MapperUtil
    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "roadmapEntityToIntegers"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "lessonEntityToIntegers"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "taskEntityToIntegers"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")
    })
    StepDTO entityToDto(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "integersToRoadmapEntityId"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "integersToLessonEntityId"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "integersToTaskEntityId"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")
    })
    StepEntity dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);


    StepModel entityToModel(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    StepEntity modelToEntity(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "integersToRoadmapModelId"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "integersToLessonModelId"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "integersToTaskModelId"),
            @Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue")
    })
    StepModel dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "roadmapModelToIntegers"),
            @Mapping(source = "lessons", target = "lessons", qualifiedByName = "lessonModelToIntegers"),
            @Mapping(source = "tasks", target = "tasks", qualifiedByName = "taskModelToIntegers"),
            @Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger")
    })
    StepDTO modelToDto(StepModel stepModel, @Context CycleAvoidingMappingContext context);


}
