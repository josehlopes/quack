package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.adapter.mapper.utils.MapperUtils;
import com.thigas.quack.domain.entity.*;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.OffsetDateTime;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface DefaultMapper {

    //USER MAPPERS
    @Named("integerToUserModel")
    default UserModel userRoadmapIntegerToModel(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(user, UserModel.class, context);
    }

    @Named("userModelToInteger")
    default Integer userRoadmapModelToInteger(UserModel userModel) {
        return MapperUtils.modelToInteger(userModel);
    }

    @Named("userEntityToInteger")
    default Integer userEntityToInteger(UserEntity userEntity) {
        return MapperUtils.mapEntityToInteger(userEntity);
    }

    @Named("userIntegerToEntity")
    default UserEntity userIntegerToEntity(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToEntity(user, UserEntity.class, context);
    }

    @Named("integerToUserEntity")
    default UserEntity integerToUserEntity(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(user, UserEntity.class, context);
    }

    @Named("stringToOffsetDateTime")
    default OffsetDateTime offSetToString(String date) {
        if (date == null) {
            return null;
        }
        return OffsetDateTime.parse(date);
    }

    @Named("offsetDateTimeToString")
    default String stringToOffSet(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return date.toString();
    }


    //ROADMAP MAPPERS
    @Named("integersToRoadmapEntityId")
    default Set<RoadmapEntity> integersToRoadmapEntityId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(roadmaps, RoadmapEntity.class, context);
    }

    @Named("roadmapEntityToIntegers")
    default Set<Integer> roadmapEntityToIntegers(Set<RoadmapEntity> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(roadmaps);
    }

    @Named("integersToRoadmapModelId")
    default Set<RoadmapModel> integersToRoadmapModelId(Set<Integer> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(roadmaps, RoadmapModel.class, context);
    }

    @Named("roadmapModelToIntegers")
    default Set<Integer> roadmapModelToIntegers(Set<RoadmapModel> roadmaps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(roadmaps);
    }

    @Named("integerToRoadmapModel")
    default RoadmapModel integerToRoadmapModel(Integer roadmapModel, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(roadmapModel, RoadmapModel.class, context);
    }

    @Named("roadmapModelToInteger")
    default Integer roadmapModelToInteger(RoadmapModel roadmapModel) {
        return MapperUtils.modelToInteger(roadmapModel);
    }

    @Named("integerToRoadmapEntity")
    default RoadmapEntity integerToRoadmapEntity(Integer roadmapEntity, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToEntity(roadmapEntity, RoadmapEntity.class, context);
    }

    @Named("roadmapEntityToInteger")
    default Integer roadmapEntityToInteger(RoadmapEntity roadmapEntity) {
        return MapperUtils.mapEntityToInteger(roadmapEntity);
    }

    //STEP MAPPERS
    @Named("stepEntityToIntegers")
    default Set<Integer> stepEntityToIntegers(Set<StepEntity> steps, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(steps);
    }

    @Named("integersToStepEntityId")
    default Set<StepEntity> integersToStepEntityId(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(stepIds, StepEntity.class, context);
    }

    @Named("integersToStepModels")
    default Set<StepModel> integersToStepModels(Set<Integer> stepIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(stepIds, StepModel.class, context);
    }

    @Named("stepModelsToIntegers")
    default Set<Integer> stepModelsToIntegers(Set<StepModel> stepModels) {
        return MapperUtils.mapModelsToIntegers(stepModels);
    }


    //STATUS MAPPER
    @Named("integerToStatusValue")
    default Status integerToStatusValue(int status) {
        return Status.values()[status];
    }

    @Named("statusValueToInteger")
    default int statusValueToInteger(Status status) {
        return status.ordinal();
    }

    //LESSON MAPPERS
    @Named("integersToLessonModelId")
    default Set<LessonModel> integersToLessonModelId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(lessons, LessonModel.class, context);
    }

    @Named("lessonModelToIntegers")
    default Set<Integer> lessonModelToIntegers(Set<LessonModel> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(lessons);
    }

    @Named("integersToLessonEntityId")
    default Set<LessonEntity> integersToLessonEntityId(Set<Integer> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(lessons, LessonEntity.class, context);
    }

    @Named("lessonEntityToIntegers")
    default Set<Integer> lessonEntityToIntegers(Set<LessonEntity> lessons, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(lessons);
    }

    //TASK MAPPERS
    @Named("taskEntityToIntegers")
    default Set<Integer> taskEntityToIntegers(Set<TaskEntity> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(tasks);
    }

    @Named("integersToTaskEntityId")
    default Set<TaskEntity> integersToTaskEntityId(Set<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(tasksIds, TaskEntity.class, context);
    }

    @Named("taskModelToIntegers")
    default Set<Integer> taskModelToIntegers(Set<TaskModel> tasks, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapModelsToIntegers(tasks);
    }

    @Named("integersToTaskModelId")
    default Set<TaskModel> integersToTaskModelId(Set<Integer> tasksIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(tasksIds, TaskModel.class, context);
    }

    @Named("taskModelToInteger")
    default TaskModel taskModelToInteger(Integer task, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(task, TaskModel.class, context);
    }

    @Named("integerToTaskModel")
    default Integer integerToTaskModel(TaskModel taskModel) {
        return MapperUtils.modelToInteger(taskModel);

    }

    @Named("taskEntityToInteger")
    default Integer taskEntityToInteger(TaskEntity taskEntity) {
        return MapperUtils.mapEntityToInteger(taskEntity);
    }

    @Named("integerToTaskEntity")
    default TaskEntity integerToTaskEntity(Integer task, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToEntity(task, TaskEntity.class, context);
    }

    //ACHIEVEMENT MAPPERS
    @Named("integerToAchievementModel")
    default AchievementModel integerToAchievementModel(Integer achievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(achievement, AchievementModel.class, context);
    }

    @Named("achievementModelToInteger")
    default Integer achievementModelToInteger(AchievementModel achievementModel) {
        return MapperUtils.modelToInteger(achievementModel);
    }

    @Named("integerToAchievementEntity")
    default AchievementEntity integerToAchievementEntity(Integer achievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegerToModel(achievement, AchievementEntity.class, context);

    }

    @Named("achievementEntityToInteger")
    default Integer achievementEntityToInteger(AchievementEntity achievementEntity) {
        return MapperUtils.mapEntityToInteger(achievementEntity);
    }

    @Named("achievementEntityToIntegers")
    default Set<Integer> userAchievementEntityToIntegers(Set<UserAchievementEntity> userAchievements, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapEntitiesToIntegers(userAchievements);
    }


    //USER ACHIEVEMENTS MAPPERS
    @Named("integersToUserAchievementEntityId")
    default Set<UserAchievementEntity> integersToUserAchievementEntityId(Set<Integer> userAchievementIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToEntities(userAchievementIds, UserAchievementEntity.class, context);
    }

    @Named("integersToUserAchievementModels")
    default Set<UserAchievementModel> integersToUserAchievementModels(Set<Integer> userAchievementIds, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.mapIntegersToModels(userAchievementIds, UserAchievementModel.class, context);
    }

    @Named("userAchievementModelsToIntegers")
    default Set<Integer> userAchievementModelsToIntegers(Set<UserAchievementModel> userAchievementModels) {
        return MapperUtils.mapModelsToIntegers(userAchievementModels);
    }
}
