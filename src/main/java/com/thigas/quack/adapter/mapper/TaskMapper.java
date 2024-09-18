package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.TaskDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "lessons", target = "lessonIds", qualifiedByName = "lessonsToIds")
    TaskDTO EntityToDto(TaskEntity taskEntity);

    @Mapping(source = "lessonIds", target = "lessons", qualifiedByName = "idsToLessons")
    TaskEntity DtoToEntity(TaskDTO taskDTO);

    @Mapping(source = "lessons", target = "lessons")
    TaskModel EntityToModel(TaskEntity taskEntity);

    @Mapping(source = "lessons", target = "lessons")
    TaskEntity ModelToEntity(TaskModel taskModel);

    @Named("lessonsToIds")
    default Set<Integer> lessonsToIds(Set<LessonEntity> lessons) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream().map(LessonEntity::getId).collect(Collectors.toSet());
    }

    @Named("idsToLessons")
    default Set<LessonEntity> idsToLessons(Set<Integer> lessonIds) {
        if (lessonIds == null) {
            return null;
        }
        return lessonIds.stream().map(id -> {
            LessonEntity lesson = new LessonEntity();
            lesson.setId(id);
            return lesson;
        }).collect(Collectors.toSet());
    }
}