package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoadmapMapper {

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapModel entityToModel(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapEntity modelToEntity(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapModel dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapDTO modelToDto(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    default List<Integer> roadmapEntityToIntegers(List<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(roadmaps);
    }

    default List<RoadmapEntity> integersToRoadmapEntityId(List<Integer> roadmapsIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(roadmapsIds, RoadmapEntity.class, context);
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

    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }
}

