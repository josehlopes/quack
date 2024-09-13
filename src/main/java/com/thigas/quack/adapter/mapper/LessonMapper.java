package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    // Mapeia Lesson para LessonModel
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    LessonModel EntityToModel(LessonEntity lesson);

    // Mapeia LessonModel para Lesson
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    LessonEntity ModelToEntity(LessonModel lessonModel);

    // Mapeia Lesson para LessonDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    LessonDTO EntityToDto(LessonEntity lesson);

    // Mapeia LessonDTO para Lesson
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    LessonEntity DtoToEntity(LessonDTO lessonDTO);

}
