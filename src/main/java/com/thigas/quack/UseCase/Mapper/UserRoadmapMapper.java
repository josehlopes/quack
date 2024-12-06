package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserRoadmapDataMapper;
import com.thigas.quack.Domain.Entity.Interface.UserRoadmap;
import com.thigas.quack.UseCase.Model.Request.UserRoadmapRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserRoadmapMapper {

    UserRoadmapMapper MAPPER = Mappers.getMapper(UserRoadmapMapper.class);

    UserRoadmapRequestModel toDsModel(UserRoadmap userRoadmap);

    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "roadmap.id", source = "roadmapId")
    })
    UserRoadmapDataMapper toDataMapper(UserRoadmapRequestModel userRoadmapRequestModel);


    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "roadmapId", source = "roadmap.id")
    })
    UserRoadmapRequestModel toDsModel(UserRoadmapDataMapper userRoadmapDataMapper);
}
