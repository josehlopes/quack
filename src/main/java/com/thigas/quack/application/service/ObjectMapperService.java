package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.adapter.mapper.*;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
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
    private UserAchievementMapper userAchievementMapper;

    @Autowired
    private UserRoadmapMapper userRoadmapMapper;

    @Autowired
    private UserTaskMapper userTaskMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    public AchievementModel toModel(AchievementDTO achievementDTO) {
        if (achievementDTO == null) {
            throw new IllegalArgumentException("AchievementDTO cannot be null");
        }
        return achievementMapper.dtoToModel(achievementDTO);
    }

    public AchievementDTO toDto(AchievementModel achievementModel) {
        if (achievementModel == null) {
            throw new IllegalArgumentException("AchievementModel cannot be null");
        }
        return achievementMapper.modelToDto(achievementModel);
    }

    public AddressModel toModel(AddressDTO addressDTO) {
        if (addressDTO == null) {
            throw new IllegalArgumentException("AddressDTO cannot be null");
        }
        return addressMapper.dtoToModel(addressDTO);
    }

    public AddressDTO toDto(AddressModel addressModel) {
        if (addressModel == null) {
            throw new IllegalArgumentException("AddressModel cannot be null");
        }
        return addressMapper.modelToDto(addressModel);
    }

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


    public StatisticsModel toModel(StatisticsDTO statisticsDTO) {
        if (statisticsDTO == null) {
            throw new IllegalArgumentException("StatisticsDTO cannot be null");
        }
        return statisticsMapper.dtoToModel(statisticsDTO);
    }

    public StatisticsDTO toDto(StatisticsModel statisticsModel) {
        if (statisticsModel == null) {
            throw new IllegalArgumentException("StatisticsModel cannot be null");
        }
        return statisticsMapper.modelToDto(statisticsModel);
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

    public UserModel toModel(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return userMapper.dtoToModel(userDTO);
    }

    public UserDTO toDto(UserModel userModel) {
        if (userModel == null) {
            throw new IllegalArgumentException("UserModel cannot be null");
        }
        return userMapper.modelToDto(userModel);
    }

    public UserAchievementModel toModel(UserAchievementDTO userAchievementDTO) {
        if (userAchievementDTO == null) {
            throw new IllegalArgumentException("UserAchievementDTO cannot be null");
        }
        return userAchievementMapper.dtoToModel(userAchievementDTO, context);
    }

    public UserAchievementDTO toDto(UserAchievementModel userAchievementModel) {
        if (userAchievementModel == null) {
            throw new IllegalArgumentException("UserAchievementModel cannot be null");
        }
        return userAchievementMapper.modelToDto(userAchievementModel, context);
    }

    public UserRoadmapModel toModel(UserRoadmapDTO userRoadmapDTO) {
        if (userRoadmapDTO == null) {
            throw new IllegalArgumentException("UserRoadmapDTO cannot be null");
        }
        return userRoadmapMapper.dtoToModel(userRoadmapDTO, context);
    }

    public UserRoadmapDTO toDto(UserRoadmapModel userRoadmapModel) {
        if (userRoadmapModel == null) {
            throw new IllegalArgumentException("UserRoadmapModel cannot be null");
        }
        return userRoadmapMapper.modelToDto(userRoadmapModel, context);
    }

    public UserTaskModel toModel(UserTaskDTO userTaskDTO) {
        if (userTaskDTO == null) {
            throw new IllegalArgumentException("UserTaskDTO cannot be null");
        }
        return userTaskMapper.dtoToModel(userTaskDTO);
    }

    public UserTaskDTO toDto(UserTaskModel userTaskModel) {
        if (userTaskModel == null) {
            throw new IllegalArgumentException("UserTaskModel cannot be null");
        }
        return userTaskMapper.modelToDto(userTaskModel);
    }
}
