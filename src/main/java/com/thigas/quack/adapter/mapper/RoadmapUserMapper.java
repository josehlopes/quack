package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.domain.entity.RoadmapUserEntity;

@Mapper(uses = { UserMapper.class, RoadmapMapper.class })
public interface RoadmapUserMapper {

    RoadmapUserMapper INSTANCE = Mappers.getMapper(RoadmapUserMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "roadmap.id", target = "roadmapId")
    RoadmapUserDTO toRoadmapUserDTO(RoadmapUserEntity roadmapUserEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roadmapId", target = "roadmap.id")
    RoadmapUserEntity toRoadmapUserEntity(RoadmapUserDTO roadmapUserDTO);
}
