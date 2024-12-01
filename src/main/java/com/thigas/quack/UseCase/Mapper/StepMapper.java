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

    @Mapping(target = "roadmapsId", source = "roadmaps")
    @Mapping(target = "lessonsId", source = "lessons")
    @Mapping(target = "tasksId", source = "tasks")
    StepRequestModel toDsModel(StepDataMapper stepDataMapper);

    StepInfoResponseModel toInfoDto(StepDataMapper stepDataMapper);

    @Mapping(target = "roadmapsId", source = "roadmaps")
    @Mapping(target = "lessonsId", source = "lessons")
    @Mapping(target = "tasksId", source = "tasks")
    StepRequestModel toDsModel(Step step);
}
