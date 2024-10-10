package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserRoadmapMapper {

    @Mappings({@Mapping(target = "user", qualifiedByName = "userEntityToInteger"),
            @Mapping(target = "roadmap", qualifiedByName = "roadmapEntityToInteger"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")})
    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);


    @Mappings({@Mapping(target = "user.id", qualifiedByName = "integerToUserEntityId"),
            @Mapping(target = "roadmap.id", qualifiedByName = "integerToRoadmapEntity"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")})
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "roadmap", target = "roadmap.id")})
    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "roadmap.id", target = "roadmap")})
    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id", qualifiedByName = "integerToUserModel"),
            @Mapping(source = "roadmap", target = "roadmap.id", qualifiedByName = "integerToRoadmapEntity"),
            @Mapping(target = "status", source = "status", qualifiedByName = "integerToStatusValue")})
    UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user", qualifiedByName = "userModelToInteger"),
            @Mapping(source = "roadmap.id", target = "roadmap", qualifiedByName = "roadmapModelToInteger"),
            @Mapping(target = "status", source = "status", qualifiedByName = "statusValueToInteger")})
    UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

}
