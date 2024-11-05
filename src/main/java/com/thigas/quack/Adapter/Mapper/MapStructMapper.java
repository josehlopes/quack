package com.thigas.quack.Adapter.Mapper;

import com.thigas.quack.Adapter.Dto.*;
import com.thigas.quack.Adapter.Mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.Infrastructure.Entity.*;
import com.thigas.quack.UseCase.Model.Request.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    AchievementDtoRequestModel dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO entityToDto(AchievementDtoRequestModel achievementDtoRequestModel, @Context CycleAvoidingMappingContext context);

    AchievementDataMapper entityToModel(AchievementDtoRequestModel achievementDtoRequestModel, @Context CycleAvoidingMappingContext context);

    AchievementDtoRequestModel modelToEntity(AchievementDataMapper achievementDataMapper, @Context CycleAvoidingMappingContext context);

    AchievementDataMapper dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);

    AchievementDTO modelToDto(AchievementDataMapper achievementDataMapper, @Context CycleAvoidingMappingContext context);

    AddressDtoRequestModel dtoToEntity(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    AddressDTO entityToDto(AddressDtoRequestModel address, @Context CycleAvoidingMappingContext context);

    AddressDataMapper entityToModel(AddressDtoRequestModel address, @Context CycleAvoidingMappingContext context);

    AddressDtoRequestModel modelToEntity(AddressDataMapper addressDataMapper, @Context CycleAvoidingMappingContext context);

    AddressDataMapper dtoToModel(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);

    AddressDTO modelToDto(AddressDataMapper addressDataMapper, @Context CycleAvoidingMappingContext context);

    LessonDTO entityToDto(LessonDtoRequestModel lessonDtoRequestModel, @Context CycleAvoidingMappingContext context);

    LessonDtoRequestModel dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    LessonDataMapper entityToModel(LessonDtoRequestModel lessonDtoRequestModel, @Context CycleAvoidingMappingContext context);

    LessonDtoRequestModel modelToEntity(LessonDataMapper lessonDataMapper, @Context CycleAvoidingMappingContext context);

    LessonDTO modelToDto(LessonDataMapper lessonDataMapper, @Context CycleAvoidingMappingContext context);

    LessonDataMapper dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    RoadmapDTO entityToDto(RoadmapDtoRequestModel roadmapDtoRequestModel, @Context CycleAvoidingMappingContext context);

    RoadmapDtoRequestModel dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    RoadmapDataMapper entityToModel(RoadmapDtoRequestModel roadmapDtoRequestModel, @Context CycleAvoidingMappingContext context);

    RoadmapDtoRequestModel modelToEntity(RoadmapDataMapper roadmapDataMapper, @Context CycleAvoidingMappingContext context);

    RoadmapDataMapper dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);

    RoadmapDTO modelToDto(RoadmapDataMapper roadmapDataMapper, @Context CycleAvoidingMappingContext context);

    StatisticsDtoRequestModel entityToDto(StatisticsDtoRequestModel statistics, @Context CycleAvoidingMappingContext context);

    StatisticsDtoRequestModel dtoToEntity(StatisticsDtoRequestModel statisticsDtoRequestModel, @Context CycleAvoidingMappingContext context);

    StatisticsDataMapper entityToModel(StatisticsDtoRequestModel statistics, @Context CycleAvoidingMappingContext context);

    StatisticsDtoRequestModel modelToEntity(StatisticsDataMapper statisticsDataMapper, @Context CycleAvoidingMappingContext context);

    StatisticsDataMapper dtoToModel(StatisticsDtoRequestModel statisticsDtoRequestModel, @Context CycleAvoidingMappingContext context);

    StatisticsDtoRequestModel modelToDto(StatisticsDataMapper statisticsDataMapper, @Context CycleAvoidingMappingContext context);

    StepDTO entityToDto(StepDtoRequestModel stepDtoRequestModel, @Context CycleAvoidingMappingContext context);

    StepDtoRequestModel dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    StepDataMapper entityToModel(StepDtoRequestModel stepDtoRequestModel, @Context CycleAvoidingMappingContext context);

    StepDtoRequestModel modelToEntity(StepDataMapper stepDataMapper, @Context CycleAvoidingMappingContext context);

    StepDataMapper dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);

    StepDTO modelToDto(StepDataMapper stepDataMapper, @Context CycleAvoidingMappingContext context);

    TaskDTO entityToDto(TaskDtoRequestModel taskDtoRequestModel, @Context CycleAvoidingMappingContext context);

    TaskDtoRequestModel dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    TaskDataMapper entityToModel(TaskDtoRequestModel taskDtoRequestModel, @Context CycleAvoidingMappingContext context);

    TaskDtoRequestModel modelToEntity(TaskDataMapper taskDataMapper, @Context CycleAvoidingMappingContext context);

    TaskDTO modelToDto(TaskDataMapper taskDataMapper, @Context CycleAvoidingMappingContext context);

    TaskDataMapper dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);

    UserAchievementDTO entityToDto(UserAchievementDtoRequestModel userAchievementDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserAchievementDtoRequestModel dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    UserAchievementDataMapper entityToModel(UserAchievementDtoRequestModel userAchievementDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserAchievementDtoRequestModel modelToEntity(UserAchievementDataMapper userAchievementDataMapper, @Context CycleAvoidingMappingContext context);

    UserAchievementDTO modelToDto(UserAchievementDataMapper userAchievementDataMapper, @Context CycleAvoidingMappingContext context);

    UserAchievementDataMapper dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    UserLessonDTO entityToDto(UserLessonDtoRequestModel userLessonDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserLessonDtoRequestModel dtoToEntity(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);

    UserLessonDataMapper entityToModel(UserLessonDtoRequestModel userLessonDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserLessonDtoRequestModel modelToEntity(UserLessonDataMapper userLessonDataMapper, @Context CycleAvoidingMappingContext context);

    UserLessonDataMapper dtoToModel(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);

    UserLessonDTO modelToDto(UserLessonDataMapper userLessonDataMapper, @Context CycleAvoidingMappingContext context);

    UserDtoRequestModel entityToDto(UserDtoRequestModel user, @Context CycleAvoidingMappingContext context);

    UserDtoRequestModel dtoToEntity(UserDtoRequestModel userDTO, @Context CycleAvoidingMappingContext context);

    UserDataMapper entityToModel(UserDtoRequestModel userDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserDtoRequestModel modelToEntity(UserDataMapper userDataMapper, @Context CycleAvoidingMappingContext context);

    UserDataMapper dtoToModel(UserDtoRequestModel userDTO, @Context CycleAvoidingMappingContext context);

    UserDtoRequestModel modelToDto(UserDataMapper userDataMapper, @Context CycleAvoidingMappingContext context);

    UserRoadmapDTO entityToDto(UserRoadmapDtoRequestModel userRoadmapDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserRoadmapDtoRequestModel dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    UserRoadmapDataMapper entityToModel(UserRoadmapDtoRequestModel userRoadmapDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserRoadmapDtoRequestModel modelToEntity(UserRoadmapDataMapper userRoadmapDataMapper, @Context CycleAvoidingMappingContext context);

    UserRoadmapDataMapper dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);

    UserRoadmapDTO modelToDto(UserRoadmapDataMapper userRoadmapDataMapper, @Context CycleAvoidingMappingContext context);

    UserStepDTO entityToDto(UserStepDtoRequestModel userStepDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserStepDtoRequestModel dtoToEntity(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);

    UserStepDataMapper entityToModel(UserStepDtoRequestModel userStepDtoRequestModel, @Context CycleAvoidingMappingContext context);

    UserStepDtoRequestModel modelToEntity(UserStepDataMapper userStepDataMapper, @Context CycleAvoidingMappingContext context);

    UserStepDataMapper dtoToModel(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);

    UserStepDTO modelToDto(UserStepDataMapper userStepDataMapper, @Context CycleAvoidingMappingContext context);

    UserTaskDTO entityToDto(UserTaskDtoRequestModel roadmapUserEntity, @Context CycleAvoidingMappingContext context);

    UserTaskDtoRequestModel dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);

    UserTaskDataMapper entityToModel(UserTaskDtoRequestModel userEntity, @Context CycleAvoidingMappingContext context);

    UserTaskDtoRequestModel modelToEntity(UserTaskDataMapper userModel, @Context CycleAvoidingMappingContext context);

    UserTaskDataMapper dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);

    UserTaskDTO modelToDto(UserTaskDataMapper userTaskDataMapper, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "registerOn", ignore = true),
            @Mapping(target = "status", ignore = true),
    })
    UserDataMapper dtoToModel(UserRegisterDTO userRegisterDTO, @Context CycleAvoidingMappingContext context);
}
