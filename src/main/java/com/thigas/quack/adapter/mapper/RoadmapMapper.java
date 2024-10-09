package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface RoadmapMapper {

    @Mappings({@Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "stepEntityToIntegers")})
    RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepEntityId")})
    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapModel entityToModel(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status"),
            @Mapping(source = "steps", target = "steps")})
    RoadmapEntity modelToEntity(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status", qualifiedByName = "integerToStatusValue"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "integersToStepModels")})
    RoadmapModel dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "status", target = "status", qualifiedByName = "statusValueToInteger"),
            @Mapping(source = "steps", target = "steps", qualifiedByName = "stepModelsToIntegers")})
    RoadmapDTO modelToDto(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);


}

