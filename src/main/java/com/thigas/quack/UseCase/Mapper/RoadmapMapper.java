package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Roadmap;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Response.RoadmapInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface RoadmapMapper {

    RoadmapMapper MAPPER = Mappers.getMapper(RoadmapMapper.class);

    RoadmapDataMapper toDataMapper(RoadmapRequestModel roadmapRequestModel);

    @Mapping(target = "stepsId", source = "steps")
    RoadmapRequestModel toDsModel(RoadmapDataMapper roadmapDataMapper);

    RoadmapInfoResponseModel toInfoDto(RoadmapDataMapper roadmapDataMapper);

    @Mapping(target = "stepsId", source = "steps")
    RoadmapRequestModel toDsModel(Roadmap roadmap);
}
