package com.thigas.quack.adapter.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.LessonDTO;
import com.thigas.quack.domain.entity.LessonEntity;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.LessonModel;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;

@Mapper
public interface LessonMapper {

    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);

    @Mapping(source = "roadmaps", target = "roadmaps")
    LessonModel toLessonModel(LessonEntity lesson);

    @Mapping(source = "roadmaps", target = "roadmaps")
    LessonEntity toLesson(LessonModel lessonModel);

    @Mapping(source = "roadmaps", target = "roadmapIds")
    LessonDTO toLessonDTO(LessonEntity lesson);

    @Mapping(source = "roadmapIds", target = "roadmaps")
    LessonEntity toLesson(LessonDTO lessonDTO);

    default Set<RoadmapModel> mapIdsToRoadmapModels(Set<Integer> roadmapIds) {
        if (roadmapIds == null) {
            return null;
        }
        return roadmapIds.stream()
                .map(id -> {
                    RoadmapModel roadmapModel = new RoadmapModel();
                    roadmapModel.setId(id);
                    return roadmapModel;
                })
                .collect(Collectors.toSet());
    }

    default Set<Integer> mapRoadmapsToIds(Set<RoadmapEntity> roadmaps) {
        if (roadmaps == null) {
            return null;
        }
        return roadmaps.stream()
                .map(RoadmapEntity::getId)
                .collect(Collectors.toSet());
    }

    default Set<RoadmapEntity> mapIdsToRoadmaps(Set<Integer> roadmapIds) {
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
}
