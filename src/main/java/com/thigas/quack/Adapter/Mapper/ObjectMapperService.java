package com.thigas.quack.Adapter.Mapper;

import com.thigas.quack.Infrastructure.Entity.*;
import com.thigas.quack.Adapter.Dto.*;
import com.thigas.quack.Adapter.Mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.UseCase.Model.Request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperService {


    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    //USER METHODS
    public UserDtoRequestModel toDtoModel(UserDataMapper userDataMapper) {
        if (userDataMapper == null) {
            throw new IllegalArgumentException("UserDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(userDataMapper, context);
    }

    public UserDataMapper toDatabaseModel(UserDtoRequestModel userDataMapper) {
        if (userDataMapper == null) {
            throw new IllegalArgumentException("UserDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userDataMapper, context);
    }

    public UserDataMapper toModel(UserDtoRequestModel userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userDTO, context);
    }

//    public UserDtoRequestModel toDatabaseModel(UserDTO userDTO) {
//        if (userDTO == null) {
//            throw new IllegalArgumentException("UserDTO cannot be null");
//        }
//        return mapStructMapper.dtoToEntity(userDTO, context);
//    }

    //USER ROADMAP METHOD
    public UserRoadmapDTO toDtoModel(UserRoadmapDtoRequestModel userRoadmapDtoRequestModel) {
        if (userRoadmapDtoRequestModel == null) {
            throw new IllegalArgumentException("UserRoadmapDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userRoadmapDtoRequestModel, context);
    }

    public UserRoadmapDtoRequestModel toDatabaseModel(UserRoadmapDTO userRoadmapDTO) {
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

    public UserRoadmapDataMapper toModel(UserRoadmapDtoRequestModel userRoadmapDtoRequestModel) {
        if (userRoadmapDtoRequestModel == null) {
            throw new IllegalArgumentException("UserRoadmapDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userRoadmapDtoRequestModel, context);
    }

    public UserRoadmapDTO toDtoModel(UserRoadmapDataMapper savedUserRoadmap) {
        if (savedUserRoadmap == null) {
            throw new IllegalArgumentException("UserRoadmapDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserRoadmap, context);
    }

    public UserRoadmapDtoRequestModel toDatabaseModel(UserRoadmapDataMapper userRoadmapDataMapper) {
        if (userRoadmapDataMapper == null) {
            throw new IllegalArgumentException("UserRoadmapDtoRequestModel cannot be null");
        }
        return mapStructMapper.modelToEntity(userRoadmapDataMapper, context);
    }

    //USER TASK METHODS
    public UserTaskDTO toDtoModel(UserTaskDtoRequestModel userTaskDtoRequestModel) {
        if (userTaskDtoRequestModel == null) {
            throw new IllegalArgumentException("UserTaskDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userTaskDtoRequestModel, context);
    }

    public UserTaskDtoRequestModel toDatabaseModel(UserTaskDTO userTaskDTO) {
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

    public UserTaskDataMapper toModel(UserTaskDtoRequestModel userTaskDtoRequestModel) {
        if (userTaskDtoRequestModel == null) {
            throw new IllegalArgumentException("UserTaskDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userTaskDtoRequestModel, context);
    }

    public UserTaskDTO toDtoModel(UserTaskDataMapper savedUserTask) {
        if (savedUserTask == null) {
            throw new IllegalArgumentException("UserTaskDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserTask, context);
    }

    //USER STEP METHOD
    public UserStepDTO toDtoModel(UserStepDtoRequestModel userStepDtoRequestModel) {
        if (userStepDtoRequestModel == null) {
            throw new IllegalArgumentException("UserStepDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userStepDtoRequestModel, context);
    }

    public UserStepDtoRequestModel toDatabaseModel(UserStepDTO userStepDTO) {
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

    public UserStepDataMapper toModel(UserStepDtoRequestModel userStepDtoRequestModel) {
        if (userStepDtoRequestModel == null) {
            throw new IllegalArgumentException("UserStepDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userStepDtoRequestModel, context);
    }

    public UserStepDTO toDtoModel(UserStepDataMapper savedUserStep) {
        if (savedUserStep == null) {
            throw new IllegalArgumentException("UserStepDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserStep, context);
    }

    public UserStepDtoRequestModel toDatabaseModel(UserStepDataMapper userStepDataMapper) {
        if (userStepDataMapper == null) {
            throw new IllegalArgumentException("UserStepDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userStepDataMapper, context);
    }

    //USER LESSON METHODS
    public UserLessonDTO toDtoModel(UserLessonDtoRequestModel userLessonDtoRequestModel) {
        if (userLessonDtoRequestModel == null) {
            throw new IllegalArgumentException("UserLessonDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userLessonDtoRequestModel, context);
    }

    public UserLessonDtoRequestModel toDatabaseModel(UserLessonDTO userLessonDTO) {
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

    public UserLessonDataMapper toModel(UserLessonDtoRequestModel userLessonDtoRequestModel) {
        if (userLessonDtoRequestModel == null) {
            throw new IllegalArgumentException("UserLessonDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userLessonDtoRequestModel, context);
    }

    public UserLessonDTO toDtoModel(UserLessonDataMapper savedUserLesson) {
        if (savedUserLesson == null) {
            throw new IllegalArgumentException("UserLessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserLesson, context);
    }

    public UserLessonDtoRequestModel toDatabaseModel(UserLessonDataMapper userLessonDataMapper) {
        if (userLessonDataMapper == null) {
            throw new IllegalArgumentException("UserLessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(userLessonDataMapper, context);
    }

    //USER ACHIEVEMENT METHODS
    public UserAchievementDTO toDtoModel(UserAchievementDtoRequestModel userAchievementDtoRequestModel) {
        if (userAchievementDtoRequestModel == null) {
            throw new IllegalArgumentException("UserAchievementDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToDto(userAchievementDtoRequestModel, context);
    }

    public UserAchievementDtoRequestModel toDatabaseModel(UserAchievementDTO userAchievementDTO) {
        if (userAchievementDTO == null) {
            throw new IllegalArgumentException("UserAchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userAchievementDTO, context);
    }
    public UserAchievementDataMapper toModel(UserAchievementDtoRequestModel userAchievementDtoRequestModel) {
        if (userAchievementDtoRequestModel == null) {
            throw new IllegalArgumentException("UserAchievementDtoRequestModel cannot be null");
        }
        return mapStructMapper.entityToModel(userAchievementDtoRequestModel, context);
    }
    public UserAchievementDTO toDtoModel(UserAchievementDataMapper userAchievementDataMapper) {
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

    public AchievementDTO toDtoModel(AchievementDataMapper achievementDataMapper) {
        if (achievementDataMapper == null) {
            throw new IllegalArgumentException("AchievementDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(achievementDataMapper, context);
    }

    public AchievementDtoRequestModel toDatabaseModel(AchievementDataMapper achievementDataMapper) {
        if (achievementDataMapper == null) {
            throw new IllegalArgumentException("AchievementDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(achievementDataMapper, context);
    }

    public AchievementDtoRequestModel toDatabaseModel(AchievementDTO achievementDTO) {
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

    public AddressDTO toDtoModel(AddressDataMapper addressDataMapper) {
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

    public LessonDTO toDtoModel(LessonDataMapper lessonDataMapper) {
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

    public RoadmapDTO toDtoModel(RoadmapDataMapper roadmapDataMapper) {
        if (roadmapDataMapper == null) {
            throw new IllegalArgumentException("LessonDataMapper cannot be null");
        }
        return mapStructMapper.modelToDto(roadmapDataMapper, context);
    }

    public RoadmapDtoRequestModel toDatabaseModel(RoadmapDataMapper roadmapDataMapper) {
        if (roadmapDataMapper == null) {
            throw new IllegalArgumentException("RoadmapDataMapper cannot be null");
        }
        return mapStructMapper.modelToEntity(roadmapDataMapper, context);
    }

    public RoadmapDtoRequestModel toDatabaseModel(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(roadmapDTO, context);
    }

    //STATISTICS METHODS
    public StatisticsDataMapper toModel(StatisticsDtoRequestModel statisticsDTO) {
        if (statisticsDTO == null) {
            throw new IllegalArgumentException("StatisticsDtoRequestModel cannot be null");
        }
        return mapStructMapper.dtoToModel(statisticsDTO, context);
    }

    public StatisticsDtoRequestModel toDtoModel(StatisticsDataMapper statisticsDataMapper) {
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

    public StepDTO toDtoModel(StepDataMapper stepDataMapper) {
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

    public TaskDTO toDtoModel(TaskDataMapper taskDataMapper) {
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
