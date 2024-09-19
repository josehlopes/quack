package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RoadmapMapper {

    RoadmapMapper INSTANCE = Mappers.getMapper(RoadmapMapper.class);

    RoadmapDTO entityToDto(RoadmapEntity roadmap);

    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO);

    RoadmapModel entityToModel(RoadmapEntity roadmap);

    RoadmapEntity modelToEntity(RoadmapModel roadmapModel);
}
