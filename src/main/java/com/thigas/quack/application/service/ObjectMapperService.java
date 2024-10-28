package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.adapter.mapper.*;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.*;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ObjectMapperService {


    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    //USER METHODS
    public UserDTO toDto(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        return mapStructMapper.modelToDto(userModel, context);
    }

    public UserEntity toEntity(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        return mapStructMapper.modelToEntity(userModel, context);
    }

    public UserModel toModel(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userDTO, context);
    }

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userDTO, context);
    }

    //USER ROADMAP METHOD
    public UserRoadmapDTO toDto(UserRoadmapEntity userRoadmapEntity) {
        if (userRoadmapEntity == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return mapStructMapper.entityToDto(userRoadmapEntity, context);
    }

    public UserRoadmapEntity toEntity(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userRoadmapDTO, context);
    }

    public UserRoadmapModel toModel(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userRoadmapDTO, context);

    }

    public UserRoadmapModel toModel(UserRoadmapEntity userRoadmapEntity) {
        if (userRoadmapEntity == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return mapStructMapper.entityToModel(userRoadmapEntity, context);
    }

    public UserRoadmapDTO toDto(UserRoadmapModel savedUserRoadmap) {
        if (savedUserRoadmap == null) {
            throw new IllegalArgumentException("UserRoadmapModel cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserRoadmap, context);
    }

    public UserRoadmapEntity toEntity(UserRoadmapModel userRoadmapModel) {
        if (userRoadmapModel == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return mapStructMapper.modelToEntity(userRoadmapModel, context);
    }

    //USER TASK METHODS
    public UserTaskDTO toDto(UserTaskEntity userTaskEntity) {
        if (userTaskEntity == null) {
            throw new IllegalArgumentException("UserTaskEntity cannot be null");
        }
        return mapStructMapper.entityToDto(userTaskEntity, context);
    }

    public UserTaskEntity toEntity(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userTaskDTO, context);
    }

    public UserTaskModel toModel(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userTaskDTO, context);

    }

    public UserTaskModel toModel(UserTaskEntity userTaskEntity) {
        if (userTaskEntity == null) {
            throw new IllegalArgumentException("UserTaskEntity cannot be null");
        }
        return mapStructMapper.entityToModel(userTaskEntity, context);
    }

    public UserTaskDTO toDto(UserTaskModel savedUserTask) {
        if (savedUserTask == null) {
            throw new IllegalArgumentException("UserTaskModel cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserTask, context);
    }

    //USER STEP METHOD
    public UserStepDTO toDto(UserStepEntity userStepEntity) {
        if (userStepEntity == null) {
            throw new IllegalArgumentException("UserStepEntity cannot be null");
        }
        return mapStructMapper.entityToDto(userStepEntity, context);
    }

    public UserStepEntity toEntity(UserStepDTO userStepDTO) {
        if (userStepDTO == null) {
            throw new IllegalArgumentException("UserStepDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userStepDTO, context);
    }

    public UserStepModel toModel(UserStepDTO userStepDTO) {
        if (userStepDTO == null) {
            throw new IllegalArgumentException("UserStepDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userStepDTO, context);

    }

    public UserStepModel toModel(UserStepEntity userStepEntity) {
        if (userStepEntity == null) {
            throw new IllegalArgumentException("UserStepEntity cannot be null");
        }
        return mapStructMapper.entityToModel(userStepEntity, context);
    }

    public UserStepDTO toDto(UserStepModel savedUserStep) {
        if (savedUserStep == null) {
            throw new IllegalArgumentException("UserStepModel cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserStep, context);
    }

    public UserStepEntity toEntity(UserStepModel userStepModel) {
        if (userStepModel == null) {
            throw new IllegalArgumentException("UserStepModel cannot be null");
        }
        return mapStructMapper.modelToEntity(userStepModel, context);
    }

    //USER LESSON METHODS
    public UserLessonDTO toDto(UserLessonEntity userLessonEntity) {
        if (userLessonEntity == null) {
            throw new IllegalArgumentException("UserLessonEntity cannot be null");
        }
        return mapStructMapper.entityToDto(userLessonEntity, context);
    }

    public UserLessonEntity toEntity(UserLessonDTO userLessonDTO) {
        if (userLessonDTO == null) {
            throw new IllegalArgumentException("UserLessonDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userLessonDTO, context);
    }

    public UserLessonModel toModel(UserLessonDTO userLessonDTO) {
        if (userLessonDTO == null) {
            throw new IllegalArgumentException("UserLessonDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(userLessonDTO, context);
    }

    public UserLessonModel toModel(UserLessonEntity userLessonEntity) {
        if (userLessonEntity == null) {
            throw new IllegalArgumentException("UserLessonEntity cannot be null");
        }
        return mapStructMapper.entityToModel(userLessonEntity, context);
    }

    public UserLessonDTO toDto(UserLessonModel savedUserLesson) {
        if (savedUserLesson == null) {
            throw new IllegalArgumentException("UserLessonModel cannot be null");
        }
        return mapStructMapper.modelToDto(savedUserLesson, context);
    }

    public UserLessonEntity toEntity(UserLessonModel userLessonModel) {
        if (userLessonModel == null) {
            throw new IllegalArgumentException("UserLessonModel cannot be null");
        }
        return mapStructMapper.modelToEntity(userLessonModel, context);
    }

    //USER ACHIEVEMENT METHODS
    public UserAchievementDTO toDto(UserAchievementEntity userAchievementEntity) {
        if (userAchievementEntity == null) {
            throw new IllegalArgumentException("UserAchievementEntity cannot be null");
        }
        return mapStructMapper.entityToDto(userAchievementEntity, context);
    }

    public UserAchievementEntity toEntity(UserAchievementDTO userAchievementDTO) {
        if (userAchievementDTO == null) {
            throw new IllegalArgumentException("UserAchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(userAchievementDTO, context);
    }
    public UserAchievementModel toModel(UserAchievementEntity userAchievementEntity) {
        if (userAchievementEntity == null) {
            throw new IllegalArgumentException("UserAchievementEntity cannot be null");
        }
        return mapStructMapper.entityToModel(userAchievementEntity, context);
    }
    public UserAchievementDTO toDto(UserAchievementModel userAchievementModel) {
        if (userAchievementModel == null) {
            throw new IllegalArgumentException("UserAchievementModel cannot be null");
        }
        return mapStructMapper.modelToDto(userAchievementModel, context);
    }

    //ACHIEVEMENT METHODS
    public AchievementModel toModel(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(achievementDTO, context);
    }

    public AchievementDTO toDto(AchievementModel achievementModel) {
        if (achievementModel == null) {
            throw new IllegalArgumentException("AchievementModel cannot be null");
        }
        return mapStructMapper.modelToDto(achievementModel, context);
    }

    public AchievementEntity toEntity(AchievementModel achievementModel) {
        if (achievementModel == null) {
            throw new IllegalArgumentException("AchievementModel cannot be null");
        }
        return mapStructMapper.modelToEntity(achievementModel, context);
    }

    public AchievementEntity toEntity(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(achievementDTO, context);
    }


    //ADDRESS METHODS
    public AddressModel toModel(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(addressDTO, context);
    }

    public AddressDTO toDto(AddressModel addressModel) {
        if (addressModel == null) {
            throw new IllegalArgumentException("AddressModel cannot be null");
        }
        return mapStructMapper.modelToDto(addressModel, context);
    }

    //LESSON METHODS
    public LessonModel toModel(LessonDTO lessonDTO) {
        if (lessonDTO == null) {
            throw new IllegalArgumentException("LessonDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(lessonDTO, context);
    }

    public LessonDTO toDto(LessonModel lessonModel) {
        if (lessonModel == null) {
            throw new IllegalArgumentException("LessonModel cannot be null");
        }
        return mapStructMapper.modelToDto(lessonModel, context);
    }

    //ROADMAP METHODS
    public RoadmapModel toModel(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("RoadmapDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(roadmapDTO, context);
    }

    public RoadmapDTO toDto(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            throw new IllegalArgumentException("LessonModel cannot be null");
        }
        return mapStructMapper.modelToDto(roadmapModel, context);
    }

    public RoadmapEntity toEntity(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            throw new IllegalArgumentException("RoadmapModel cannot be null");
        }
        return mapStructMapper.modelToEntity(roadmapModel, context);
    }

    public RoadmapEntity toEntity(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return mapStructMapper.dtoToEntity(roadmapDTO, context);
    }

    //STATISTICS METHODS
    public StatisticsModel toModel(StatisticsDTO statisticsDTO) {
        if (statisticsDTO == null) {
            throw new IllegalArgumentException("StatisticsDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(statisticsDTO, context);
    }

    public StatisticsDTO toDto(StatisticsModel statisticsModel) {
        if (statisticsModel == null) {
            throw new IllegalArgumentException("StatisticsModel cannot be null");
        }
        return mapStructMapper.modelToDto(statisticsModel, context);
    }

    public StepModel toModel(StepDTO stepDTO) {
        if (stepDTO == null) {
            throw new IllegalArgumentException("StepDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(stepDTO, context);
    }

    public StepDTO toDto(StepModel stepModel) {
        if (stepModel == null) {
            throw new IllegalArgumentException("StepModel cannot be null");
        }
        return mapStructMapper.modelToDto(stepModel, context);
    }

    //TASK METHODS
    public TaskModel toModel(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("TaskDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(taskDTO, context);
    }

    public TaskDTO toDto(TaskModel taskModel) {
        if (taskModel == null) {
            throw new IllegalArgumentException("TaskModel cannot be null");
        }
        return mapStructMapper.modelToDto(taskModel, context);
    }

    //REGISTER METHODS
    public UserModel toModel(RegisterUserDTO registerUserDTO) {
        if (registerUserDTO == null) {
            throw new IllegalArgumentException("RegisterUserDTO cannot be null");
        }
        return mapStructMapper.dtoToModel(registerUserDTO, context);
    }

}
