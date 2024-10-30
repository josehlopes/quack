package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.*;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    AchievementEntity dtoToEntity(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);
    AchievementDTO entityToDto(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);
    AchievementModel entityToModel(AchievementEntity achievementEntity, @Context CycleAvoidingMappingContext context);
    AchievementEntity modelToEntity(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);
    AchievementModel dtoToModel(AchievementDTO achievementDTO, @Context CycleAvoidingMappingContext context);
    AchievementDTO modelToDto(AchievementModel achievementModel, @Context CycleAvoidingMappingContext context);

    AddressEntity dtoToEntity(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);
    AddressDTO entityToDto(AddressEntity address, @Context CycleAvoidingMappingContext context);
    AddressModel entityToModel(AddressEntity address, @Context CycleAvoidingMappingContext context);
    AddressEntity modelToEntity(AddressModel addressModel, @Context CycleAvoidingMappingContext context);
    AddressModel dtoToModel(AddressDTO addressDTO, @Context CycleAvoidingMappingContext context);
    AddressDTO modelToDto(AddressModel addressModel, @Context CycleAvoidingMappingContext context);

    LessonDTO entityToDto(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);
    LessonEntity dtoToEntity(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);
    LessonModel entityToModel(LessonEntity lessonEntity, @Context CycleAvoidingMappingContext context);
    LessonEntity modelToEntity(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);
    LessonDTO modelToDto(LessonModel lessonModel, @Context CycleAvoidingMappingContext context);
    LessonModel dtoToModel(LessonDTO lessonDTO, @Context CycleAvoidingMappingContext context);

    RoadmapDTO entityToDto(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);
    RoadmapEntity dtoToEntity(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);
    RoadmapModel entityToModel(RoadmapEntity roadmapEntity, @Context CycleAvoidingMappingContext context);
    RoadmapEntity modelToEntity(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);
    RoadmapModel dtoToModel(RoadmapDTO roadmapDTO, @Context CycleAvoidingMappingContext context);
    RoadmapDTO modelToDto(RoadmapModel roadmapModel, @Context CycleAvoidingMappingContext context);

    StatisticsDTO entityToDto(StatisticsEntity statistics, @Context CycleAvoidingMappingContext context);
    StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);
    StatisticsModel entityToModel(StatisticsEntity statistics, @Context CycleAvoidingMappingContext context);
    StatisticsEntity modelToEntity(StatisticsModel statisticsModel, @Context CycleAvoidingMappingContext context);
    StatisticsModel dtoToModel(StatisticsDTO statisticsDTO, @Context CycleAvoidingMappingContext context);
    StatisticsDTO modelToDto(StatisticsModel statisticsModel, @Context CycleAvoidingMappingContext context);

    StepDTO entityToDto(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);
    StepEntity dtoToEntity(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);
    StepModel entityToModel(StepEntity stepEntity, @Context CycleAvoidingMappingContext context);
    StepEntity modelToEntity(StepModel stepModel, @Context CycleAvoidingMappingContext context);
    StepModel dtoToModel(StepDTO stepDTO, @Context CycleAvoidingMappingContext context);
    StepDTO modelToDto(StepModel stepModel, @Context CycleAvoidingMappingContext context);

    TaskDTO entityToDto(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);
    TaskEntity dtoToEntity(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);
    TaskModel entityToModel(TaskEntity taskEntity, @Context CycleAvoidingMappingContext context);
    TaskEntity modelToEntity(TaskModel taskModel, @Context CycleAvoidingMappingContext context);
    TaskDTO modelToDto(TaskModel taskModel, @Context CycleAvoidingMappingContext context);
    TaskModel dtoToModel(TaskDTO taskDTO, @Context CycleAvoidingMappingContext context);
   
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);
    UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);
    UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);
    
    UserLessonDTO entityToDto(UserLessonEntity userLessonEntity, @Context CycleAvoidingMappingContext context);
    UserLessonEntity dtoToEntity(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);
    UserLessonModel entityToModel(UserLessonEntity userLessonEntity, @Context CycleAvoidingMappingContext context);
    UserLessonEntity modelToEntity(UserLessonModel userLessonModel, @Context CycleAvoidingMappingContext context);
    UserLessonModel dtoToModel(UserLessonDTO userLessonDTO, @Context CycleAvoidingMappingContext context);
    UserLessonDTO modelToDto(UserLessonModel userLessonModel, @Context CycleAvoidingMappingContext context);

    UserDTO entityToDto(UserEntity user, @Context CycleAvoidingMappingContext context);
    UserEntity dtoToEntity(UserDTO userDTO, @Context CycleAvoidingMappingContext context);
    UserModel entityToModel(UserEntity userEntity, @Context CycleAvoidingMappingContext context);
    UserEntity modelToEntity(UserModel userModel, @Context CycleAvoidingMappingContext context);
    UserModel dtoToModel(UserDTO userDTO, @Context CycleAvoidingMappingContext context);
    UserDTO modelToDto(UserModel userModel, @Context CycleAvoidingMappingContext context);

    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);
    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, @Context CycleAvoidingMappingContext context);
    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);
    UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, @Context CycleAvoidingMappingContext context);
    UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, @Context CycleAvoidingMappingContext context);

    UserStepDTO entityToDto(UserStepEntity userStepEntity, @Context CycleAvoidingMappingContext context);
    UserStepEntity dtoToEntity(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);
    UserStepModel entityToModel(UserStepEntity userStepEntity, @Context CycleAvoidingMappingContext context);
    UserStepEntity modelToEntity(UserStepModel userStepModel, @Context CycleAvoidingMappingContext context);
    UserStepModel dtoToModel(UserStepDTO userStepDTO, @Context CycleAvoidingMappingContext context);
    UserStepDTO modelToDto(UserStepModel userStepModel, @Context CycleAvoidingMappingContext context);

    UserTaskDTO entityToDto(UserTaskEntity roadmapUserEntity, @Context CycleAvoidingMappingContext context);
    UserTaskEntity dtoToEntity(UserTaskDTO roadmapUserDTO, @Context CycleAvoidingMappingContext context);
    UserTaskModel entityToModel(UserTaskEntity userEntity, @Context CycleAvoidingMappingContext context);
    UserTaskEntity modelToEntity(UserTaskModel userModel, @Context CycleAvoidingMappingContext context);
    UserTaskModel dtoToModel(UserTaskDTO userTaskDTO, @Context CycleAvoidingMappingContext context);
    UserTaskDTO modelToDto(UserTaskModel userTaskModel, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "registerAt", ignore = true),
            @Mapping(target = "status", ignore = true),
    })
    UserModel dtoToModel(UserRegisterDTO userRegisterDTO, @Context CycleAvoidingMappingContext context);
}
