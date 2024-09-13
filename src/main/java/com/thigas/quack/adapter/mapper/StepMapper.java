package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface StepMapper {

    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);

    @Mapping(source = "roadmaps", target = "roadmapIds", qualifiedByName = "roadmapsToIds")
    @Mapping(source = "lessons", target = "lessonIds", qualifiedByName = "lessonsToIds")
    StepDTO EntityToDto(StepEntity stepEntity);

    @Mapping(source = "roadmapIds", target = "roadmaps", qualifiedByName = "idsToRoadmaps")
    @Mapping(source = "lessonIds", target = "lessons", qualifiedByName = "idsToLessons")
    StepEntity DtoToEntity(StepDTO stepDTO);

    @Mapping(source = "roadmaps", target = "roadmaps")
    @Mapping(source = "lessons", target = "lessons")
    StepModel EntityToModel(StepEntity stepEntity);

    @Mapping(source = "roadmaps", target = "roadmaps")
    @Mapping(source = "lessons", target = "lessons")
    StepEntity ModelToEntity(StepModel stepModel);

    @Named("roadmapsToIds")
    default Set<Integer> roadmapsToIds(Set<RoadmapEntity> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream()
                .map(RoadmapEntity::getId)
                .collect(Collectors.toSet());
    }

    @Named("idsToRoadmaps")
    default Set<RoadmapEntity> idsToRoadmaps(Set<Integer> roadmapIds) {
        if (roadmapIds == null) {
            return null;
        }
        return roadmapIds.stream()
                .map(id -> {
                    RoadmapEntity roadmap = new RoadmapEntity();
                    roadmap.setId(id);
                    return roadmap;
                })
                .collect(Collectors.toSet());
    }

    @Named("lessonsToIds")
    default Set<Integer> lessonsToIds(Set<LessonEntity> lessons) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream()
                .map(LessonEntity::getId)
                .collect(Collectors.toSet());
    }

    @Named("idsToLessons")
    default Set<LessonEntity> idsToLessons(Set<Integer> lessonIds) {
        if (lessonIds == null) {
            return null;
        }
        return lessonIds.stream()
                .map(id -> {
                    LessonEntity lesson = new LessonEntity();
                    lesson.setId(id);
                    return lesson;
                })
                .collect(Collectors.toSet());
    }
}
