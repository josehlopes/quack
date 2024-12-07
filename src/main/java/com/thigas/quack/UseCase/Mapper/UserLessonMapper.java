package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserLessonDataMapper;
import com.thigas.quack.Domain.Entity.Interface.UserLesson;
import com.thigas.quack.UseCase.Model.Request.CompletedLessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserLessonRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserLessonMapper {

    UserLessonMapper MAPPER = Mappers.getMapper(UserLessonMapper.class);

    UserLessonRequestModel toDsModel(UserLesson userLesson);

    @Mappings({
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "lesson.id", source = "lessonId"),
            @Mapping(target = "completed", source = "completed")
    })
    UserLessonDataMapper toDataMapper(UserLessonRequestModel userLessonRequestModel);

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "lessonId", source = "lesson.id"),
            @Mapping(target = "completed", source = "completed")
    })
    UserLessonRequestModel toDsModel(UserLessonDataMapper userLessonDataMapper);
}
