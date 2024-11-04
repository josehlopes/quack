package com.thigas.quack.Adapter.Mapper;

import com.thigas.quack.Infrastructure.Model.*;
import com.thigas.quack.Adapter.Dto.*;
import com.thigas.quack.Adapter.Mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.UseCase.Model.Request.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    AchievementDsRequestModel dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);
    AchievementDTO entityToDto(AchievementDsRequestModel achievementDsRequestModel, @Context CycleAvoidingMappingContext context);
    AchievementDataMapper entityToModel(AchievementDsRequestModel achievementDsRequestModel, @Context CycleAvoidingMappingContext context);
    AchievementDsRequestModel modelToEntity(AchievementDataMapper achievementDataMapper, @Context CycleAvoidingMappingContext context);
    AchievementDataMapper dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);
    AchievementDTO modelToDto(AchievementDataMapper achievementDataMapper, @Context CycleAvoidingMappingContext context);

    AddressDsRequestModel dtoToEntity(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);
    AddressDTO entityToDto(AddressDsRequestModel address, @Context CycleAvoidingMappingContext context);
    AddressDataMapper entityToModel(AddressDsRequestModel address, @Context CycleAvoidingMappingContext context);
    AddressDsRequestModel modelToEntity(AddressDataMapper addressDataMapper, @Context CycleAvoidingMappingContext context);
    AddressDataMapper dtoToModel(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);
    AddressDTO modelToDto(AddressDataMapper addressDataMapper, @Context CycleAvoidingMappingContext context);

    LessonDTO entityToDto(LessonDsRequestModel lessonDsRequestModel, @Context CycleAvoidingMappingContext context);
    LessonDsRequestModel dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);
    LessonDataMapper entityToModel(LessonDsRequestModel lessonDsRequestModel, @Context CycleAvoidingMappingContext context);
    LessonDsRequestModel modelToEntity(LessonDataMapper lessonDataMapper, @Context CycleAvoidingMappingContext context);
    LessonDTO modelToDto(LessonDataMapper lessonDataMapper, @Context CycleAvoidingMappingContext context);
    LessonDataMapper dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    RoadmapDTO entityToDto(RoadmapDsRequestModel roadmapDsRequestModel, @Context CycleAvoidingMappingContext context);
    RoadmapDsRequestModel dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);
    RoadmapDataMapper entityToModel(RoadmapDsRequestModel roadmapDsRequestModel, @Context CycleAvoidingMappingContext context);
    RoadmapDsRequestModel modelToEntity(RoadmapDataMapper roadmapDataMapper, @Context CycleAvoidingMappingContext context);
    RoadmapDataMapper dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);
    RoadmapDTO modelToDto(RoadmapDataMapper roadmapDataMapper, @Context CycleAvoidingMappingContext context);

    StatisticsDTO entityToDto(StatisticsDsRequestModel statistics, @Context CycleAvoidingMappingContext context);
    StatisticsDsRequestModel dtoToEntity(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);
    StatisticsDataMapper entityToModel(StatisticsDsRequestModel statistics, @Context CycleAvoidingMappingContext context);
    StatisticsDsRequestModel modelToEntity(StatisticsDataMapper statisticsDataMapper, @Context CycleAvoidingMappingContext context);
    StatisticsDataMapper dtoToModel(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);
    StatisticsDTO modelToDto(StatisticsDataMapper statisticsDataMapper, @Context CycleAvoidingMappingContext context);

    StepDTO entityToDto(StepDsRequestModel stepDsRequestModel, @Context CycleAvoidingMappingContext context);
    StepDsRequestModel dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);
    StepDataMapper entityToModel(StepDsRequestModel stepDsRequestModel, @Context CycleAvoidingMappingContext context);
    StepDsRequestModel modelToEntity(StepDataMapper stepDataMapper, @Context CycleAvoidingMappingContext context);
    StepDataMapper dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);
    StepDTO modelToDto(StepDataMapper stepDataMapper, @Context CycleAvoidingMappingContext context);

    TaskDTO entityToDto(TaskDsRequestModel taskDsRequestModel, @Context CycleAvoidingMappingContext context);
    TaskDsRequestModel dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);
    TaskDataMapper entityToModel(TaskDsRequestModel taskDsRequestModel, @Context CycleAvoidingMappingContext context);
    TaskDsRequestModel modelToEntity(TaskDataMapper taskDataMapper, @Context CycleAvoidingMappingContext context);
    TaskDTO modelToDto(TaskDataMapper taskDataMapper, @Context CycleAvoidingMappingContext context);
    TaskDataMapper dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);
   
    UserAchievementDTO entityToDto(UserAchievementDsRequestModel userAchievementDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserAchievementDsRequestModel dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);
    UserAchievementDataMapper entityToModel(UserAchievementDsRequestModel userAchievementDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserAchievementDsRequestModel modelToEntity(UserAchievementDataMapper userAchievementDataMapper, @Context CycleAvoidingMappingContext context);
    UserAchievementDTO modelToDto(UserAchievementDataMapper userAchievementDataMapper, @Context CycleAvoidingMappingContext context);
    UserAchievementDataMapper dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);
    
    UserLessonDTO entityToDto(UserLessonDsRequestModel userLessonDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserLessonDsRequestModel dtoToEntity(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);
    UserLessonDataMapper entityToModel(UserLessonDsRequestModel userLessonDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserLessonDsRequestModel modelToEntity(UserLessonDataMapper userLessonDataMapper, @Context CycleAvoidingMappingContext context);
    UserLessonDataMapper dtoToModel(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);
    UserLessonDTO modelToDto(UserLessonDataMapper userLessonDataMapper, @Context CycleAvoidingMappingContext context);

    UserDTO entityToDto(UserDsRequestModel user, @Context CycleAvoidingMappingContext context);
    UserDsRequestModel dtoToEntity(UserDTO userDTO, @Context CycleAvoidingMappingContext context);
    UserDataMapper entityToModel(UserDsRequestModel userDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserDsRequestModel modelToEntity(UserDataMapper userDataMapper, @Context CycleAvoidingMappingContext context);
    UserDataMapper dtoToModel(UserDTO userDTO, @Context CycleAvoidingMappingContext context);
    UserDTO modelToDto(UserDataMapper userDataMapper, @Context CycleAvoidingMappingContext context);

    UserRoadmapDTO entityToDto(UserRoadmapDsRequestModel userRoadmapDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserRoadmapDsRequestModel dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);
    UserRoadmapDataMapper entityToModel(UserRoadmapDsRequestModel userRoadmapDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserRoadmapDsRequestModel modelToEntity(UserRoadmapDataMapper userRoadmapDataMapper, @Context CycleAvoidingMappingContext context);
    UserRoadmapDataMapper dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);
    UserRoadmapDTO modelToDto(UserRoadmapDataMapper userRoadmapDataMapper, @Context CycleAvoidingMappingContext context);

    UserStepDTO entityToDto(UserStepDsRequestModel userStepDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserStepDsRequestModel dtoToEntity(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);
    UserStepDataMapper entityToModel(UserStepDsRequestModel userStepDsRequestModel, @Context CycleAvoidingMappingContext context);
    UserStepDsRequestModel modelToEntity(UserStepDataMapper userStepDataMapper, @Context CycleAvoidingMappingContext context);
    UserStepDataMapper dtoToModel(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);
    UserStepDTO modelToDto(UserStepDataMapper userStepDataMapper, @Context CycleAvoidingMappingContext context);

    UserTaskDTO entityToDto(UserTaskDsRequestModel roadmapUserEntity, @Context CycleAvoidingMappingContext context);
    UserTaskDsRequestModel dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);
    UserTaskDataMapper entityToModel(UserTaskDsRequestModel userEntity, @Context CycleAvoidingMappingContext context);
    UserTaskDsRequestModel modelToEntity(UserTaskDataMapper userModel, @Context CycleAvoidingMappingContext context);
    UserTaskDataMapper dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);
    UserTaskDTO modelToDto(UserTaskDataMapper userTaskDataMapper, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "registerOn", ignore = true),
            @Mapping(target = "status", ignore = true),
    })
    UserDataMapper dtoToModel(UserRegisterDTO userRegisterDTO, @Context CycleAvoidingMappingContext context);
}
