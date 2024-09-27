package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(source = "steps", target = "stepsIds", ignore = true)
    LessonDTO entityToDto(LessonEntity lesson);

    @Mapping(source = "stepsIds", target = "steps", ignore = true)
    LessonEntity dtoToEntity(LessonDTO lessonDTO);

    LessonEntity modelToEntity(LessonModel lessonModel);

    LessonModel entityToModel(LessonEntity lesson);

}
