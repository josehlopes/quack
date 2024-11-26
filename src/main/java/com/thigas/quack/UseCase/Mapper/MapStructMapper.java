package com.thigas.quack.UseCase.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thigas.quack.Adapter.Entity.*;
import com.thigas.quack.UseCase.Model.Request.LessonRequestModel;
import com.thigas.quack.UseCase.Model.Request.RoadmapRequestModel;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import com.thigas.quack.UseCase.Model.Request.*;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructMapper {

    //TODO: Estudar melhor o uso do @Context
    //TODO: Estudar mais sobre mapstruct e ver como funciona os campos ignoraveis
    //TODO: Talvez estudar sobre ModelMapper


    AchievementDataMapper mapAchievementDtoRequestToDataMapper(AchievementRequestModel achievementRequestModel);

    AchievementRequestModel mapAchievementDataMapperToDtoRequest(AchievementDataMapper achievementDataMapper);

    LessonDataMapper mapLessonDtoRequestToDataMapper(LessonRequestModel lessonRequestModel);

    LessonRequestModel mapLessonDataMapperToDtoRequest(LessonDataMapper lessonDataMapper);

    RoadmapDataMapper mapRoadmapDtoRequestToDataMapper(RoadmapRequestModel roadmapRequestModel);

    RoadmapRequestModel mapRoadmapDataMapperToDtoRequest(RoadmapDataMapper roadmapDataMapper);

    StatisticsDataMapper mapStatisticsDtoRequestToDataMapper(StatisticsRequestModel statisticsRequestModel);

    StatisticsRequestModel mapStatisticsDataMapperToDtoRequest(StatisticsDataMapper statisticsDataMapper);

    StepDataMapper mapStepDtoRequestToDataMapper(StepRequestModel stepRequestModel);

    StepRequestModel mapStepDataMapperToDtoRequest(StepDataMapper stepDataMapper);

//    StepLessonDataMapper  mapStepLessonDtoRequestToDataMapper (StepLessonDtoRequestModel statisticsDtoRequestModel);
//    StepLessonDtoRequestModel  mapStepLessonDataMapperToDtoRequest (StepLessonDataMapper statisticsDataMapper);

    TaskDataMapper mapTaskDtoRequestToDataMapper(TaskRequestModel taskRequestModel);

    TaskRequestModel mapTaskDataMapperToDtoRequest(TaskDataMapper taskDataMapper);

    UserAchievementDataMapper mapUserAchievementDtoRequestToDataMapper(UserAchievementDsRequestModel userAchievementDsRequestModel);

    UserAchievementDsRequestModel mapUserAchievementDataMapperToDtoRequest(UserAchievementDataMapper userAchievementDataMapper);

    UserLessonDataMapper mapUserLessonDtoRequestToDataMapper(UserLessonRequestModel userLessonRequestModel);

    UserLessonRequestModel mapUserLessonDataMapperToDtoRequest(UserLessonDataMapper userLessonDataMapper);

    UserRoadmapDataMapper mapUserRoadmapDtoRequestToDataMapper(UserRoadmapRequestModel userRoadmapRequestModel);

    UserRoadmapRequestModel mapUserRoadmapDataMapperToDtoRequest(UserRoadmapDataMapper userRoadmapDataMapper);

    UserStepDataMapper mapUserStepDtoRequestToDataMapper(UserStepRequestModel userStepRequestModel);

    UserStepRequestModel mapUserStepDataMapperToDtoRequest(UserStepDataMapper userStepDataMapper);

    UserTaskDataMapper mapUserTaskDtoRequestToDataMapper(UserTaskRequestModel userTaskRequestModel);

    UserTaskRequestModel mapUserTaskDataMapperToDtoRequest(UserTaskDataMapper userTaskDataMapper);

    default TaskTextRequestModel mapStringToTaskTextDto(String tasktext) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(tasktext, TaskTextRequestModel.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON string", e);
        }
    }

    default String mapTaskTextDtoToString(TaskTextRequestModel value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert TaskTextRequestModel to JSON string", e);
        }
    }

    default OffsetDateTime mapStringToOffsetDateTime(String value) {
        return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    default String mapOffsetDateTimeToString(OffsetDateTime value) {
        return value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}