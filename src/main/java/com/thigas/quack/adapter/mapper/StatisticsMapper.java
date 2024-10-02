package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsDTO entityToDto(StatisticsEntity statistics);

    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO);

    @Mappings({
            @Mapping(source = "user.id", target = "user.id"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsModel entityToModel(StatisticsEntity statistics);

    @Mappings({
            @Mapping(source = "user.id", target = "user.id"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsEntity modelToEntity(StatisticsModel statisticsModel);


    @Mappings({
            @Mapping(source = "user", target = "user.id"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsModel dtoToModel(StatisticsDTO statisticsDTO);

    @Mappings({
            @Mapping(source = "user.id", target = "user"),
            @Mapping(source = "roadmapsCompleted", target = "roadmapsCompleted"),
            @Mapping(source = "stepsCompleted", target = "stepsCompleted")
    })
    StatisticsDTO modelToDto(StatisticsModel statisticsModel);

    default Set<RoadmapModel> integersToRoadmapModelId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(roadmaps, RoadmapModel.class, context);
    }

    default Set<Integer> roadmapModelIdToIntegers(Set<RoadmapModel> roadmaps) {
        return MapperUtils.modelsToIntegers(roadmaps);
    }

    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(roadmaps, RoadmapEntity.class, context);
    }

    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(roadmaps);
    }

    default Set<AchievementModel> integersToAchievementModelId(Set<Integer> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(achievements, AchievementModel.class, context);
    }

    default Set<Integer> achievementModelToIntegers(Set<AchievementModel> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.modelsToIntegers(achievements);
    }

    default Set<AchievementEntity> integersToAchievementEntityId(Set<Integer> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToEntities(achievements, AchievementEntity.class, context);
    }

    default Set<Integer> achievementEntityToIntegers(Set<AchievementEntity> achievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.entitiesToIntegers(achievements);
    }





    default Status map(int value) {
        return Status.fromValue(value);
    }

    default int map(Status status) {
        return status.getValue();
    }
}
