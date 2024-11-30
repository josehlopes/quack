package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.LessonDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Lesson;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Response.LessonInfoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface LessonMapper {

    LessonMapper MAPPER = Mappers.getMapper(LessonMapper.class);

    LessonDataMapper toDataMapper(LessonRequestModel lessonRequestModel);

    @Mapping(target = "stepsId", source = "steps", qualifiedByName = "mapStepDataMapperToIds")
    LessonRequestModel toDsModel(LessonDataMapper lessonDataMapper);

    LessonInfoResponseModel toInfoDto(LessonDataMapper lessonDataMapper);

    @Mapping(target = "stepsId", source = "steps", qualifiedByName = "mapStepsToIds")
    LessonRequestModel toDsModel(Lesson lesson);
}
