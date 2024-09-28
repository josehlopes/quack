package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StepMapper {

    StepMapper INSTANCE = Mappers.getMapper(StepMapper.class);

    @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "roadmapsToIds")
    // @Mapping(source = "lessons", target = "lessons", qualifiedByName =
    // "lessonsToIds")
    @Mapping(source = "lessons", target = "lessons", ignore = true)
    @Mapping(source = "tasks", target = "tasks", ignore = true)
    @Mapping(target = "status", source = "status", qualifiedByName = "stepStatusToInt")
    StepDTO entityToDto(StepEntity stepEntity);

    @Mapping(source = "roadmaps", target = "roadmaps", qualifiedByName = "idsToRoadmaps")
    // @Mapping(source = "lessons", target = "lessons", qualifiedByName =
    // "idsToLessons")
    @Mapping(source = "lessons", target = "lessons", ignore = true)
    @Mapping(source = "tasks", target = "tasks", ignore = true)
    @Mapping(target = "status", source = "status", qualifiedByName = "stepIntToStatus")
    StepEntity dtoToEntity(StepDTO stepDTO);

    @Mapping(source = "roadmaps", target = "roadmaps", ignore = true)
    @Mapping(source = "lessons", target = "lessons", ignore = true)
    @Mapping(source = "tasks", target = "tasks", ignore = true)
    StepModel entityToModel(StepEntity stepEntity);

    @Mapping(source = "roadmaps", target = "roadmaps", ignore = true)
    @Mapping(source = "lessons", target = "lessons", ignore = true)
    @Mapping(source = "tasks", target = "tasks", ignore = true)
    StepEntity modelToEntity(StepModel stepModel);

    @Named("roadmapsToIds")
    default Set<Integer> roadmapsToIds(Set<RoadmapEntity> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(RoadmapEntity::getId).collect(Collectors.toSet());
    }

    @Named("idsToRoadmaps")
    default Set<RoadmapEntity> idsToRoadmaps(Set<Integer> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(id -> {
            RoadmapEntity roadmap = new RoadmapEntity();
            roadmap.setId(id);
            return roadmap;
        }).collect(Collectors.toSet());
    }

    // @Named("lessonsToIds")
    // default Set<Integer> lessonsToIds(Set<LessonEntity> lessons) {
    // if (lessons == null) {
    // return null;
    // }
    // return lessons.stream().map(LessonEntity::getId).collect(Collectors.toSet());
    // }

    // @Named("idsToLessons")
    // default Set<LessonEntity> idsToLessons(Set<Integer> lessons) {
    // if (lessons == null) {
    // return null;
    // }
    // return lessons.stream().map(id -> {
    // LessonEntity lesson = new LessonEntity();
    // lesson.setId(id);
    // return lesson;
    // }).collect(Collectors.toSet());
    // }

    // @Named("taskToIds")
    // default Set<Integer> taskToIds(Set<TaskEntity> tasks) {
    // if (tasks == null) {
    // return null;
    // }
    // return tasks.stream().map(TaskEntity::getId).collect(Collectors.toSet());
    // }

    // @Named("idsToTasks")
    // default Set<TaskEntity> idsToTasks(Set<Integer> tasksIds) {
    // if (tasksIds == null) {
    // return null;
    // }
    // return tasksIds.stream().map(id -> {
    // TaskEntity task = new TaskEntity();
    // task.setId(id);
    // return task;
    // }).collect(Collectors.toSet());
    // }

    @Named("stepStatusToInt")
    default int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    @Named("stepIntToStatus")
    default Status intToStatus(int value) {
        return Status.fromValue(value);
    }
}
