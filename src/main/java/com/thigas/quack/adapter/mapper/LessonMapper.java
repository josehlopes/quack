package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.Lesson;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    // Mapeia Lesson para LessonModel
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    @Mapping(source = "roadmaps", target = "roadmaps")
    LessonModel toLessonModel(Lesson lesson);

    // Mapeia LessonModel para Lesson
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    @Mapping(source = "roadmaps", target = "roadmaps")
    Lesson toLesson(LessonModel lessonModel);

    // Mapeia Lesson para LessonDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    @Mapping(source = "roadmaps", target = "roadmapIds")
    LessonDTO toLessonDTO(Lesson lesson);

    // Mapeia LessonDTO para Lesson
    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "language", target = "language")
    @Mapping(source = "imagePath", target = "imagePath")
    @Mapping(source = "roadmapIds", target = "roadmaps")
    Lesson toLesson(LessonDTO lessonDTO);
}
