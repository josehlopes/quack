package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    LessonModel entityToModel(LessonEntity lesson);

    LessonEntity modelToEntity(LessonModel lessonModel);

    LessonDTO entityToDto(LessonEntity lesson);

    LessonEntity dtoToEntity(LessonDTO lessonDTO);

}
