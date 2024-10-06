package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.*;

import java.util.Set;

@Mapper(uses = {StepMapper.class}, componentModel = "spring")
public interface RoadmapMapper {

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps" , qualifiedByName = "stepEntityToIntegers")})
    RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepEntityId")})
    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapModel entityToModel(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapEntity modelToEntity(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepModels")})
    RoadmapModel dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "stepModelsToIntegers")})
    RoadmapDTO modelToDto(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    @Named("integersToRoadmapEntityId")
    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(roadmaps, RoadmapEntity.class, context);}

    @Named("roadmapEntityToIntegers")
    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
            return MapperUtils.mapEntitiesToIntegers(roadmaps);
    }

    @Named("integersToRoadmapModelId")
    default Set<RoadmapModel> integersToRoadmapModelId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(roadmaps, RoadmapModel.class, context);}

    @Named("roadmapModelToIntegers")
    default Set<Integer> roadmapModelToIntegers(Set<RoadmapModel> roadmaps, @Context CycleAvoidingMappingContext context) {
            return MapperUtils.mapModelsToIntegers(roadmaps);
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


    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }
}

