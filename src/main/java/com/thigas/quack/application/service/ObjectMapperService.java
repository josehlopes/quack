package com.thigas.quack.application.service;

import com.thigas.quack.adapter.dto.*;
import com.thigas.quack.adapter.mapper.*;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.stream.Collectors;

@Service
@Component
public class ObjectMapperService {

    @Autowired
    @Lazy
    private AchievementMapper achievementMapper;

    @Autowired
    @Lazy
    private AddressMapper addressMapper;

    @Autowired
    @Lazy
    private LessonMapper lessonMapper;

    @Autowired
    @Lazy
    private RoadmapMapper roadmapMapper;

    @Autowired
    @Lazy
    private StatisticsMapper statisticsMapper;

    @Autowired
    @Lazy
    private StepMapper stepMapper;

    @Autowired
    @Lazy
    private TaskMapper taskMapper;

    @Autowired
    @Lazy
    private UserMapper userMapper;

    @Autowired
    @Lazy
    private UserRoadmapMapper userRoadmapMapper;

    @Autowired
    private CycleAvoidingMappingContext context;



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
    
    public RoadmapEntity toEntity(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            throw new IllegalArgumentException("RoadmapModel cannot be null");
        }
        return roadmapMapper.modelToEntity(roadmapModel, context);
    }

    public UserEntity toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return userMapper.dtoToEntity(userDTO, context);
    }

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
        return userMapper.dtoToModel(userDTO, context);
    }

    public RoadmapEntity toEntity(RoadmapDTO roadmapDTO) {
        if (roadmapDTO == null) {
            throw new IllegalArgumentException("UserDTO cannot be null");
        }
        return roadmapMapper.dtoToEntity(roadmapDTO, context);
    }

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
}
