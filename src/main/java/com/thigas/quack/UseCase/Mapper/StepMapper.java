package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Step;
import com.thigas.quack.UseCase.Model.Request.StepRequestModel;
import com.thigas.quack.UseCase.Model.Response.StepInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface StepMapper {

    StepMapper MAPPER = Mappers.getMapper(StepMapper.class);

    StepDataMapper toDataMapper(StepRequestModel stepRequestModel);

    @Mapping(target = "roadmapsId", source = "roadmaps", qualifiedByName = "mapRoadmapDataMapperToIds")
    @Mapping(target = "lessonsId", source = "lessons", qualifiedByName = "mapLessonDataMapperToIds")
    @Mapping(target = "tasksId", source = "tasks", qualifiedByName = "mapTaskDataMapperToIds")
    StepRequestModel toDsModel(StepDataMapper stepDataMapper);

    StepInfoResponseModel toInfoDto(StepDataMapper stepDataMapper);

    @Mapping(target = "roadmapsId", source = "roadmaps", qualifiedByName = "mapRoadmapToIds")
    @Mapping(target = "lessonsId", source = "lessons", qualifiedByName = "mapLessonToIds")
    @Mapping(target = "tasksId", source = "tasks", qualifiedByName = "mapTaskToIds")
    StepRequestModel toDsModel(Step step);
}
