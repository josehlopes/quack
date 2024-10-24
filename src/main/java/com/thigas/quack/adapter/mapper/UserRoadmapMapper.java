package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserRoadmapMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "user.id", target = "roadmap"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")})
    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);


    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "roadmap", target = "roadmap.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);


    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);

    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "roadmap", target = "roadmap.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "roadmap.id", target = "roadmap"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")})
    UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

}
