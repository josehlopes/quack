package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.RoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

@Mapper
public interface RoadmapMapper {

    RoadmapMapper INSTANCE = Mappers.getMapper(RoadmapMapper.class);

    @Mapping(source = "id", target = "id")
    RoadmapDTO toRoadmapDTO(RoadmapEntity roadmap);

    RoadmapEntity toRoadmap(RoadmapDTO roadmapDTO);

    @Mapping(source = "id", target = "id")
    RoadmapModel toRoadmapModel(RoadmapEntity roadmap);

    @Mapping(source = "id", target = "id")
    RoadmapEntity toRoadmap(RoadmapModel roadmapModel);

    default RoadmapModel map(Integer userId) {
        if (userId == null) {
            return null;
        }
        RoadmapModel userModel = new RoadmapModel();
        userModel.setId(userId);
        return userModel;
    }

    default Integer map(RoadmapModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }
}
