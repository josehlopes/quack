package com.thigas.quack.Adapter.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thigas.quack.Adapter.Entity.*;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Response.AddressInfoDtoResponseModel;
import com.thigas.quack.UseCase.Model.Response.UserLoginDtoResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper {

    //TODO: Estudar melhor o uso do @Context
    //TODO: Estudar mais sobre mapstruct e ver como funciona os campos ignoraveis
    //TODO: Talvez estudar sobre ModelMapper


    AchievementDataMapper mapAchievementDtoRequestToDataMapper(AchievementDtoRequestModel achievementDtoRequestModel);

    AchievementDtoRequestModel mapAchievementDataMapperToDtoRequest(AchievementDataMapper achievementDataMapper);

    @Mapping(source = "userId", target = "user.id")
    AddressDataMapper mapAddressDtoRequestToDataMapper(AddressDtoRequestModel addressDtoRequestModel);

    AddressDtoRequestModel mapAddressDataMapperToDtoRequest(AddressDataMapper addressDataMapper);

    AddressInfoDtoResponseModel mapAddressDataMapperToInfoDtoResponse(AddressDataMapper addressDataMapper);

    LessonDataMapper mapLessonDtoRequestToDataMapper(LessonDtoRequestModel lessonDtoRequestModel);

    LessonDtoRequestModel mapLessonDataMapperToDtoRequest(LessonDataMapper lessonDataMapper);

    RoadmapDataMapper mapRoadmapDtoRequestToDataMapper(RoadmapDtoRequestModel roadmapDtoRequestModel);

    RoadmapDtoRequestModel mapRoadmapDataMapperToDtoRequest(RoadmapDataMapper roadmapDataMapper);

    StatisticsDataMapper mapStatisticsDtoRequestToDataMapper(StatisticsDtoRequestModel statisticsDtoRequestModel);

    StatisticsDtoRequestModel mapStatisticsDataMapperToDtoRequest(StatisticsDataMapper statisticsDataMapper);

    StepDataMapper mapStepDtoRequestToDataMapper(StepDtoRequestModel stepDtoRequestModel);

    StepDtoRequestModel mapStepDataMapperToDtoRequest(StepDataMapper stepDataMapper);

//    StepLessonDataMapper  mapStepLessonDtoRequestToDataMapper (StepLessonDtoRequestModel statisticsDtoRequestModel);
//    StepLessonDtoRequestModel  mapStepLessonDataMapperToDtoRequest (StepLessonDataMapper statisticsDataMapper);

    TaskDataMapper mapTaskDtoRequestToDataMapper(TaskDtoRequestModel taskDtoRequestModel);

    TaskDtoRequestModel mapTaskDataMapperToDtoRequest(TaskDataMapper taskDataMapper);

    UserAchievementDataMapper mapUserAchievementDtoRequestToDataMapper(UserAchievementDtoRequestModel userAchievementDtoRequestModel);

    UserAchievementDtoRequestModel mapUserAchievementDataMapperToDtoRequest(UserAchievementDataMapper userAchievementDataMapper);

    UserDataMapper mapUserRegisterDtoToUserDataMapper(UserRegisterDtoRequestModel userRegisterDtoRequestModel);

    UserLoginDtoResponseModel mapUserDataMapperToUserLoginDtoResponse(UserDataMapper userDataMapper);

    UserDtoRequestModel mapUserDataMapperToUserDtoRequest(UserDataMapper userDataMapper);

    UserDataMapper mapUserDtoRequestToUserDataMapper(UserDtoRequestModel userDtoRequestModel);

    UserLessonDataMapper mapUserLessonDtoRequestToDataMapper(UserLessonDtoRequestModel userLessonDtoRequestModel);

    UserLessonDtoRequestModel mapUserLessonDataMapperToDtoRequest(UserLessonDataMapper userLessonDataMapper);

    UserRoadmapDataMapper mapUserRoadmapDtoRequestToDataMapper(UserRoadmapDtoRequestModel userRoadmapDtoRequestModel);

    UserRoadmapDtoRequestModel mapUserRoadmapDataMapperToDtoRequest(UserRoadmapDataMapper userRoadmapDataMapper);

    UserStepDataMapper mapUserStepDtoRequestToDataMapper(UserStepDtoRequestModel userStepDtoRequestModel);

    UserStepDtoRequestModel mapUserStepDataMapperToDtoRequest(UserStepDataMapper userStepDataMapper);

    UserTaskDataMapper mapUserTaskDtoRequestToDataMapper(UserTaskDtoRequestModel userTaskDtoRequestModel);

    UserTaskDtoRequestModel mapUserTaskDataMapperToDtoRequest(UserTaskDataMapper userTaskDataMapper);

    default TaskTextDtoRequestModel mapStringToTaskTextDto(String tasktext) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(tasktext, TaskTextDtoRequestModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON string", e);
        }
    }

    default String mapTaskTextDtoToString(TaskTextDtoRequestModel value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert TaskTextDtoRequestModel to JSON string", e);
        }
    }

    default OffsetDateTime mapStringToOffsetDateTime(String value) {
        return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    default String mapOffsetDateTimeToString(OffsetDateTime value) {
        return value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}