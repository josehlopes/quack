package com.thigas.quack.Adapter.Mapper;

import com.thigas.quack.Infrastructure.Model.*;
import com.thigas.quack.Adapter.Dto.*;
import com.thigas.quack.Adapter.Mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.UseCase.Model.Request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ObjectMapperService {


    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    //USER METHODS
    public UserDTO toDto(UserDataMapper userDataMapper) {
        if (userDataMapper == null) {
            throw new IllegalArgumentException("UserDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(userDataMapper, context);
    }

    public UserDsRequestModel toEntity(UserDataMapper userDataMapper) {
        if (userDataMapper == null) {
            throw new IllegalArgumentException("UserDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userDataMapper, context);
    }

    public UserDataMapper toModel(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userDTO, context);
    }

    public UserDsRequestModel toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userDTO, context);
    }

    //USER ROADMAP METHOD
    public UserRoadmapDTO toDto(UserRoadmapDsRequestModel userRoadmapDsRequestModel) {
        if (userRoadmapDsRequestModel == null) {
            throw new IllegalArgumentException("UserRoadmapDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userRoadmapDsRequestModel, context);
    }

    public UserRoadmapDsRequestModel toEntity(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userRoadmapDTO, context);
    }

    public UserRoadmapDataMapper toModel(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userRoadmapDTO, context);

    }

    public UserRoadmapDataMapper toModel(UserRoadmapDsRequestModel userRoadmapDsRequestModel) {
        if (userRoadmapDsRequestModel == null) {
            throw new IllegalArgumentException("UserRoadmapDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userRoadmapDsRequestModel, context);
    }

    public UserRoadmapDTO toDto(UserRoadmapDataMapper savedUserRoadmap) {
        if (savedUserRoadmap == null) {
            throw new IllegalArgumentException("UserRoadmapDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserRoadmap, context);
    }

    public UserRoadmapDsRequestModel toEntity(UserRoadmapDataMapper userRoadmapDataMapper) {
        if (userRoadmapDataMapper == null) {
            throw new IllegalArgumentException("UserRoadmapDsRequestModel cannot be null");
        }
        return mapStructMapper.modelToEntity(userRoadmapDataMapper, context);
    }

    //USER TASK METHODS
    public UserTaskDTO toDto(UserTaskDsRequestModel userTaskDsRequestModel) {
        if (userTaskDsRequestModel == null) {
            throw new IllegalArgumentException("UserTaskDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userTaskDsRequestModel, context);
    }

    public UserTaskDsRequestModel toEntity(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userTaskDTO, context);
    }

    public UserTaskDataMapper toModel(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userTaskDTO, context);

    }

    public UserTaskDataMapper toModel(UserTaskDsRequestModel userTaskDsRequestModel) {
        if (userTaskDsRequestModel == null) {
            throw new IllegalArgumentException("UserTaskDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userTaskDsRequestModel, context);
    }

    public UserTaskDTO toDto(UserTaskDataMapper savedUserTask) {
        if (savedUserTask == null) {
            throw new IllegalArgumentException("UserTaskDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserTask, context);
    }

    //USER STEP METHOD
    public UserStepDTO toDto(UserStepDsRequestModel userStepDsRequestModel) {
        if (userStepDsRequestModel == null) {
            throw new IllegalArgumentException("UserStepDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userStepDsRequestModel, context);
    }

    public UserStepDsRequestModel toEntity(UserStepDTO userStepDTO) {
        if (userStepDTO == null) {
            throw new IllegalArgumentException("UserStepDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userStepDTO, context);
    }

    public UserStepDataMapper toModel(UserStepDTO userStepDTO) {
        if (userStepDTO == null) {
            throw new IllegalArgumentException("UserStepDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userStepDTO, context);

    }

    public UserStepDataMapper toModel(UserStepDsRequestModel userStepDsRequestModel) {
        if (userStepDsRequestModel == null) {
            throw new IllegalArgumentException("UserStepDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userStepDsRequestModel, context);
    }

    public UserStepDTO toDto(UserStepDataMapper savedUserStep) {
        if (savedUserStep == null) {
            throw new IllegalArgumentException("UserStepDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserStep, context);
    }

    public UserStepDsRequestModel toEntity(UserStepDataMapper userStepDataMapper) {
        if (userStepDataMapper == null) {
            throw new IllegalArgumentException("UserStepDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userStepDataMapper, context);
    }

    //USER LESSON METHODS
    public UserLessonDTO toDto(UserLessonDsRequestModel userLessonDsRequestModel) {
        if (userLessonDsRequestModel == null) {
            throw new IllegalArgumentException("UserLessonDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userLessonDsRequestModel, context);
    }

    public UserLessonDsRequestModel toEntity(UserLessonDTO userLessonDTO) {
        if (userLessonDTO == null) {
            throw new IllegalArgumentException("UserLessonDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userLessonDTO, context);
    }

    public UserLessonDataMapper toModel(UserLessonDTO userLessonDTO) {
        if (userLessonDTO == null) {
            throw new IllegalArgumentException("UserLessonDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userLessonDTO, context);
    }

    public UserLessonDataMapper toModel(UserLessonDsRequestModel userLessonDsRequestModel) {
        if (userLessonDsRequestModel == null) {
            throw new IllegalArgumentException("UserLessonDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userLessonDsRequestModel, context);
    }

    public UserLessonDTO toDto(UserLessonDataMapper savedUserLesson) {
        if (savedUserLesson == null) {
            throw new IllegalArgumentException("UserLessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserLesson, context);
    }

    public UserLessonDsRequestModel toEntity(UserLessonDataMapper userLessonDataMapper) {
        if (userLessonDataMapper == null) {
            throw new IllegalArgumentException("UserLessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userLessonDataMapper, context);
    }

    //USER ACHIEVEMENT METHODS
    public UserAchievementDTO toDto(UserAchievementDsRequestModel userAchievementDsRequestModel) {
        if (userAchievementDsRequestModel == null) {
            throw new IllegalArgumentException("UserAchievementDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userAchievementDsRequestModel, context);
    }

    public UserAchievementDsRequestModel toEntity(UserAchievementDTO userAchievementDTO) {
        if (userAchievementDTO == null) {
            throw new IllegalArgumentException("UserAchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userAchievementDTO, context);
    }
    public UserAchievementDataMapper toModel(UserAchievementDsRequestModel userAchievementDsRequestModel) {
        if (userAchievementDsRequestModel == null) {
            throw new IllegalArgumentException("UserAchievementDsRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userAchievementDsRequestModel, context);
    }
    public UserAchievementDTO toDto(UserAchievementDataMapper userAchievementDataMapper) {
        if (userAchievementDataMapper == null) {
            throw new IllegalArgumentException("UserAchievementDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(userAchievementDataMapper, context);
    }

    //ACHIEVEMENT METHODS
    public AchievementDataMapper toModel(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(achievementDTO, context);
    }

    public AchievementDTO toDto(AchievementDataMapper achievementDataMapper) {
        if (achievementDataMapper == null) {
            throw new IllegalArgumentException("AchievementDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(achievementDataMapper, context);
    }

    public AchievementDsRequestModel toEntity(AchievementDataMapper achievementDataMapper) {
        if (achievementDataMapper == null) {
            throw new IllegalArgumentException("AchievementDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(achievementDataMapper, context);
    }

    public AchievementDsRequestModel toEntity(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(achievementDTO, context);
    }


    //ADDRESS METHODS
    public AddressDataMapper toModel(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(addressDTO, context);
    }

    public AddressDTO toDto(AddressDataMapper addressDataMapper) {
        if (addressDataMapper == null) {
            throw new IllegalArgumentException("AddressDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(addressDataMapper, context);
    }

    //LESSON METHODS
    public LessonDataMapper toModel(LessonDTO lessonDTO) {
        if (lessonDTO == null) {
            throw new IllegalArgumentException("LessonDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(lessonDTO, context);
    }

    public LessonDTO toDto(LessonDataMapper lessonDataMapper) {
        if (lessonDataMapper == null) {
            throw new IllegalArgumentException("LessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(lessonDataMapper, context);
    }

    //ROADMAP METHODS
    public RoadmapDataMapper toModel(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("RoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(roadmapDTO, context);
    }

    public RoadmapDTO toDto(RoadmapDataMapper roadmapDataMapper) {
        if (roadmapDataMapper == null) {
            throw new IllegalArgumentException("LessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(roadmapDataMapper, context);
    }

    public RoadmapDsRequestModel toEntity(RoadmapDataMapper roadmapDataMapper) {
        if (roadmapDataMapper == null) {
            throw new IllegalArgumentException("RoadmapDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(roadmapDataMapper, context);
    }

    public RoadmapDsRequestModel toEntity(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(roadmapDTO, context);
    }

    //STATISTICS METHODS
    public StatisticsDataMapper toModel(StatisticsDTO statisticsDTO) {
        if (statisticsDTO == null) {
            throw new IllegalArgumentException("StatisticsDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(statisticsDTO, context);
    }

    public StatisticsDTO toDto(StatisticsDataMapper statisticsDataMapper) {
        if (statisticsDataMapper == null) {
            throw new IllegalArgumentException("StatisticsDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(statisticsDataMapper, context);
    }

    public StepDataMapper toModel(StepDTO stepDTO) {
        if (stepDTO == null) {
            throw new IllegalArgumentException("StepDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(stepDTO, context);
    }

    public StepDTO toDto(StepDataMapper stepDataMapper) {
        if (stepDataMapper == null) {
            throw new IllegalArgumentException("StepDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(stepDataMapper, context);
    }

    //TASK METHODS
    public TaskDataMapper toModel(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("TaskDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(taskDTO, context);
    }

    public TaskDTO toDto(TaskDataMapper taskDataMapper) {
        if (taskDataMapper == null) {
            throw new IllegalArgumentException("TaskDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(taskDataMapper, context);
    }

    //REGISTER METHODS
    public UserDataMapper toModel(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO == null) {
            throw new IllegalArgumentException("UserRegisterDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userRegisterDTO, context);
    }

}
