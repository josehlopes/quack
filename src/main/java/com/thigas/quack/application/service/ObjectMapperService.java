package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.adapter.mapper.*;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.entity.UserTaskEntity;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ObjectMapperService {

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private RoadmapMapper roadmapMapper;

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Autowired
    private StepMapper stepMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoadmapMapper userRoadmapMapper;

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    //USER METHODS
    public UserDTO toDto(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        return userMapper.modelToDto(userModel, context);
    }

    public UserEntity toEntity(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        return userMapper.modelToEntity(userModel, context);
    }

    public UserModel toModel(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return userMapper.dtoToModel(userDTO, context);
    }

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return userMapper.dtoToEntity(userDTO, context);
    }


    //USER ROADMAP METHOD
    public UserRoadmapDTO toDto(UserRoadmapEntity userRoadmapEntity) {
        if (userRoadmapEntity == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return userRoadmapMapper.entityToDto(userRoadmapEntity, context);
    }

    public UserRoadmapEntity toEntity(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return userRoadmapMapper.dtoToEntity(userRoadmapDTO, context);
    }

    public UserRoadmapModel toModel(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return userRoadmapMapper.dtoToModel(userRoadmapDTO, context);

    }

    public UserRoadmapModel toModel(UserRoadmapEntity userRoadmapEntity) {
        if (userRoadmapEntity == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return userRoadmapMapper.entityToModel(userRoadmapEntity, context);
    }

    public UserRoadmapDTO toDto(UserRoadmapModel savedUserRoadmap) {
        if (savedUserRoadmap == null) {
            throw new IllegalArgumentException("UserRoadmapModel cannot be null");
        }
        return userRoadmapMapper.modelToDto(savedUserRoadmap, context);
    }

    public UserRoadmapEntity toEntity(UserRoadmapModel userRoadmapModel) {
        if (userRoadmapModel == null) {
            throw new IllegalArgumentException("UserRoadmapEntity cannot be null");
        }
        return userRoadmapMapper.modelToEntity(userRoadmapModel, context);
    }

    //USER TASK METHODS
    public UserTaskDTO toDto(UserTaskEntity userTaskEntity) {
        if (userTaskEntity == null) {
            throw new IllegalArgumentException("UserTaskEntity cannot be null");
        }
        return userTaskMapper.entityToDto(userTaskEntity, context);
    }

    public UserTaskEntity toEntity(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return userTaskMapper.dtoToEntity(userTaskDTO, context);
    }

    public UserTaskModel toModel(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return userTaskMapper.dtoToModel(userTaskDTO, context);

    }

    public UserTaskModel toModel(UserTaskEntity userTaskEntity) {
        if (userTaskEntity == null) {
            throw new IllegalArgumentException("UserTaskEntity cannot be null");
        }
        return userTaskMapper.entityToModel(userTaskEntity, context);
    }

    public UserTaskDTO toDto(UserTaskModel savedUserTask) {
        if (savedUserTask == null) {
            throw new IllegalArgumentException("UserTaskModel cannot be null");
        }
        return userTaskMapper.modelToDto(savedUserTask, context);
    }

    //ACHIEVEMENT METHODS
    public AchievementModel toModel(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return achievementMapper.dtoToModel(achievementDTO, context);
    }

    public AchievementDTO toDto(AchievementModel achievementModel) {
        if (achievementModel == null) {
            throw new IllegalArgumentException("AchievementModel cannot be null");
        }
        return achievementMapper.modelToDto(achievementModel, context);
    }

    //ADDRESS METHODS
    public AddressModel toModel(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO cannot be null");
        }
        return addressMapper.dtoToModel(addressDTO, context);
    }

    public AddressDTO toDto(AddressModel addressModel) {
        if (addressModel == null) {
            throw new IllegalArgumentException("AddressModel cannot be null");
        }
        return addressMapper.modelToDto(addressModel, context);
    }

    //LESSON METHODS
    public LessonModel toModel(LessonDTO lessonDTO) {
        if (lessonDTO == null) {
            throw new IllegalArgumentException("LessonDTO cannot be null");
        }
        return lessonMapper.dtoToModel(lessonDTO, context);
    }

    public LessonDTO toDto(LessonModel lessonModel) {
        if (lessonModel == null) {
            throw new IllegalArgumentException("LessonModel cannot be null");
        }
        return lessonMapper.modelToDto(lessonModel, context);
    }

    //ROADMAP METHODS
    public RoadmapModel toModel(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("RoadmapDTO cannot be null");
        }
        return roadmapMapper.dtoToModel(roadmapDTO, context);
    }

    public RoadmapDTO toDto(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            throw new IllegalArgumentException("LessonModel cannot be null");
        }
        return roadmapMapper.modelToDto(roadmapModel, context);
    }

    public RoadmapEntity toEntity(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            throw new IllegalArgumentException("RoadmapModel cannot be null");
        }
        return roadmapMapper.modelToEntity(roadmapModel, context);
    }

    public RoadmapEntity toEntity(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return roadmapMapper.dtoToEntity(roadmapDTO, context);
    }

    //STATISTICS METHODS
    public StatisticsModel toModel(StatisticsDTO statisticsDTO) {
        if (statisticsDTO == null) {
            throw new IllegalArgumentException("StatisticsDTO cannot be null");
        }
        return statisticsMapper.dtoToModel(statisticsDTO, context);
    }

    public StatisticsDTO toDto(StatisticsModel statisticsModel) {
        if (statisticsModel == null) {
            throw new IllegalArgumentException("StatisticsModel cannot be null");
        }
        return statisticsMapper.modelToDto(statisticsModel, context);
    }

    public StepModel toModel(StepDTO stepDTO) {
        if (stepDTO == null) {
            throw new IllegalArgumentException("StepDTO cannot be null");
        }
        return stepMapper.dtoToModel(stepDTO, context);
    }

    public StepDTO toDto(StepModel stepModel) {
        if (stepModel == null) {
            throw new IllegalArgumentException("StepModel cannot be null");
        }
        return stepMapper.modelToDto(stepModel, context);
    }

    //TASK METHODS
    public TaskModel toModel(TaskDTO taskDTO) {
        if (taskDTO == null) {
            throw new IllegalArgumentException("TaskDTO cannot be null");
        }
        return taskMapper.dtoToModel(taskDTO, context);
    }

    public TaskDTO toDto(TaskModel taskModel) {
        if (taskModel == null) {
            throw new IllegalArgumentException("TaskModel cannot be null");
        }
        return taskMapper.modelToDto(taskModel, context);
    }
}
