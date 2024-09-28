package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoadmapMapper {

    RoadmapMapper INSTANCE = Mappers.getMapper(RoadmapMapper.class);

    @Mapping(target = "status", source = "status", qualifiedByName = "roadmapStatusToInt")
    @Mapping(target = "steps", source = "steps", ignore = true)
    RoadmapDTO entityToDto(RoadmapEntity roadmap);

    @Mapping(target = "status", source = "status", qualifiedByName = "roadmapIntToStatus")
    @Mapping(target = "steps", source = "steps", ignore = true)
    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO);

    RoadmapModel entityToModel(RoadmapEntity roadmap);

    RoadmapEntity modelToEntity(RoadmapModel roadmapModel);

    @Named("roadmapStatusToInt")
    default int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    @Named("roadmapIntToStatus")
    default Status intToStatus(int value) {
        return Status.fromValue(value);
    }
}
