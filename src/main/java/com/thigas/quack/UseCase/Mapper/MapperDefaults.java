package com.thigas.quack.UseCase.Mapper;

import com.google.gson.Gson;
import com.thigas.quack.Adapter.Entity.LessonDataMapper;
import com.thigas.quack.Adapter.Entity.RoadmapDataMapper;
import com.thigas.quack.Adapter.Entity.StepDataMapper;
import com.thigas.quack.Adapter.Entity.TaskDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Lesson;
import com.thigas.quack.Domain.Entity.Interface.Roadmap;
import com.thigas.quack.Domain.Entity.Interface.Step;
import com.thigas.quack.Domain.Entity.Interface.Task;
import com.thigas.quack.UseCase.Model.Request.TaskTextRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDefaults {

    default String map(OffsetDateTime value) {
        return value != null ? value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    default OffsetDateTime map(String value) {
        return value != null ? OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME) : null;
    }

    default <T> Set<T> idsToItemSet(Set<Integer> ids, Set<T> allItems, Function<T, Integer> getId) {
        return ids.stream()
                .map(id -> allItems.stream()
                        .filter(item -> getId.apply(item).equals(id))
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("idsToItemSetStep")
    default Set<Step> idsToItemSetStep(Set<Integer> ids, Set<Step> allSteps) {
        return ids.stream()
                .map(id -> allSteps.stream()
                        .filter(step -> step.getId() == id)
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("idsToItemSetRoadmap")
    default Set<Roadmap> idsToItemSetRoadmap(Set<Integer> ids, Set<Roadmap> allRoadmaps) {
        return ids.stream()
                .map(id -> allRoadmaps.stream()
                        .filter(roadmap -> roadmap.getId() == id)
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("idsToItemSetLesson")
    default Set<Lesson> idsToItemSetLesson(Set<Integer> ids, Set<Lesson> allLessons) {
        return ids.stream()
                .map(id -> allLessons.stream()
                        .filter(lesson -> lesson.getId() == id)
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("idsToItemSetTask")
    default Set<Task> idsToItemSetTask(Set<Integer> ids, Set<Task> allTasks) {
        return ids.stream()
                .map(id -> allTasks.stream()
                        .filter(task -> task.getId() == id)
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toSet());
    }

    @Named("mapStepsToIds")
    default Set<Integer> mapStepsToIds(Set<Step> steps) {
        if (steps == null) {
            return null;
        }
        return steps.stream()
                .map(Step::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapStepDataMapperToIds")
    default Set<Integer> mapStepDataMapperToIds(Set<StepDataMapper> stepsData) {
        if (stepsData == null) {
            return null;
        }
        return stepsData.stream()
                .map(StepDataMapper::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapRoadmapToIds")
    default Set<Integer> mapRoadmapToIds(Set<Roadmap> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream()
                .map(Roadmap::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapRoadmapDataMapperToIds")
    default Set<Integer> mapRoadmapDataMapperToIds(Set<RoadmapDataMapper> roadmapsData) {
        if (roadmapsData == null) {
            return null;
        }
        return roadmapsData.stream()
                .map(RoadmapDataMapper::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapLessonToIds")
    default Set<Integer> mapLessonToIds(Set<Lesson> lessons) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream()
                .map(Lesson::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapLessonDataMapperToIds")
    default Set<Integer> mapLessonDataMapperToIds(Set<LessonDataMapper> lessonsData) {
        if (lessonsData == null) {
            return null;
        }
        return lessonsData.stream()
                .map(LessonDataMapper::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapTaskToIds")
    default Set<Integer> mapTaskToIds(Set<Task> tasks) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream()
                .map(Task::getId)
                .collect(Collectors.toSet());
    }

    @Named("mapTaskDataMapperToIds")
    default Set<Integer> mapTaskDataMapperToIds(Set<TaskDataMapper> tasksData) {
        if (tasksData == null) {
            return null;
        }
        return tasksData.stream()
                .map(TaskDataMapper::getId)
                .collect(Collectors.toSet());
    }
}

