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

import java.util.Set;

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

    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(roadmaps);
    }

    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmapsIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(roadmapsIds, RoadmapEntity.class, context);
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

    default int roadmapStatusToInteger(Status status) {
        return MapperUtils.statusToInt(status);
    }

    default Status roadmapIntegerToStatus(int value) {
        return MapperUtils.intToStatus(value);
    }
}

