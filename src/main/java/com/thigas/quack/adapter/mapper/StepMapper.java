package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StepDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StepEntity;
import com.thigas.quack.domain.entity.TaskEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StepModel;
import com.thigas.quack.infrastructure.persistence.entity.TaskModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface StepMapper {

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepDTO entityToDto(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepEntity dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepModel entityToModel(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepEntity modelToEntity(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepModel dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(source = "roadmaps", target = "roadmaps"),
            @Mapping(source = "lessons", target = "lessons"),
            @Mapping(source = "tasks", target = "tasks")
    })
    StepDTO modelToDto(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    default List<RoadmapModel> integersToRoadmapModelId(List<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(id -> {
            RoadmapModel roadmap = context.getMappedInstance(id, RoadmapModel.class);
            if (roadmap == null) {
                roadmap = new RoadmapModel();
                roadmap.setId(id);
                context.storeMappedInstance(id, roadmap);
            }
            return roadmap;
        }).collect(Collectors.toList());
    }

    default List<Integer> roadmapModelIdToIntegers(List<RoadmapModel> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(RoadmapModel::getId).collect(Collectors.toList());
    }

    default List<RoadmapEntity> integersToRoadmapEntityId(List<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(id -> {
            RoadmapEntity roadmap = context.getMappedInstance(id, RoadmapEntity.class);
            if (roadmap == null) {
                roadmap = new RoadmapEntity();
                roadmap.setId(id);
                context.storeMappedInstance(id, roadmap);
            }
            return roadmap;
        }).collect(Collectors.toList());
    }

    default List<Integer> roadmapEntityToIntegers(List<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream().map(RoadmapEntity::getId).collect(Collectors.toList());
    }

    default List<LessonModel> integersToLessonModelId(List<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream().map(id -> {
            LessonModel lesson = context.getMappedInstance(id, LessonModel.class);
            if (lesson == null) {
                lesson = new LessonModel();
                lesson.setId(id);
                context.storeMappedInstance(id, lesson);
            }
            return lesson;
        }).collect(Collectors.toList());
    }

    default List<Integer> lessonModelToIntegers(List<LessonModel> lessons, @Context CycleAvoidingMappingContext context) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream().map(LessonModel::getId).collect(Collectors.toList());
    }

    default List<LessonEntity> integersToLessonEntityId(List<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream().map(id -> {
            LessonEntity lesson = context.getMappedInstance(id, LessonEntity.class);
            if (lesson == null) {
                lesson = new LessonEntity();
                lesson.setId(id);
                context.storeMappedInstance(id, lesson);
            }
            return lesson;
        }).collect(Collectors.toList());
    }

    default List<Integer> lessonEntityToIntegers(List<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        if (lessons == null) {
            return null;
        }
        return lessons.stream().map(LessonEntity::getId).collect(Collectors.toList());
    }

    default List<TaskModel> integersToTaskModelId(List<Integer> tasks, @Context CycleAvoidingMappingContext context) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream().map(id -> {
            TaskModel task = context.getMappedInstance(id, TaskModel.class);
            if (task == null) {
                task = new TaskModel();
                task.setId(id);
                context.storeMappedInstance(id, task);
            }
            return task;
        }).collect(Collectors.toList());
    }

    default List<Integer> taskModelToIntegers(List<TaskModel> tasks, @Context CycleAvoidingMappingContext context) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream().map(TaskModel::getId).collect(Collectors.toList());
    }

    default List<TaskEntity> integersToTaskEntityId(List<Integer> tasks, @Context CycleAvoidingMappingContext context) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream().map(id -> {
            TaskEntity task = context.getMappedInstance(id, TaskEntity.class);
            if (task == null) {
                task = new TaskEntity();
                task.setId(id);
                context.storeMappedInstance(id, task);
            }
            return task;
        }).collect(Collectors.toList());
    }

    default List<Integer> taskEntityToIntegers(List<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        if (tasks == null) {
            return null;
        }
        return tasks.stream().map(TaskEntity::getId).collect(Collectors.toList());
    }

    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }
}
