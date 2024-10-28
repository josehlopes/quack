package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserLessonDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.UserLessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserLessonModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserLessonMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "lesson.id", target = "lesson"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")
    })
    UserLessonDTO entityToDto(UserLessonEntity userLessonEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "lesson", target = "lesson.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")
    })
    UserLessonEntity dtoToEntity(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);


    UserLessonModel entityToModel(UserLessonEntity userLessonEntity, @Context CycleAvoidingMappingContext context);

    UserLessonEntity modelToEntity(UserLessonModel userLessonModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "lesson", target = "lesson.id"),
            @Mapping(target = "status", qualifiedByName = "integerToStatusValue")
    })
    UserLessonModel dtoToModel(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "lesson.id", target = "lesson"),
            @Mapping(target = "status", qualifiedByName = "statusValueToInteger")
    })
    UserLessonDTO modelToDto(UserLessonModel userLessonModel, @Context CycleAvoidingMappingContext context);
}