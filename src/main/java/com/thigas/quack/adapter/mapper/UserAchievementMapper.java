package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.OffsetDateTime;

@Mapper(uses = {UserMapper.class, AchievementMapper.class}, componentModel = "spring")
public interface UserAchievementMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd")
    })
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd")
    })
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO);


    UserAchievementModel entityToModel(UserAchievementEntity userEntity);

    UserAchievementEntity modelToEntity(UserAchievementModel userModel);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd")
    })
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd")
    })
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel);

    default UserModel userToModel(Integer user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToModel(user, UserModel.class, context);
    }

    default Integer userModelToId(UserModel userModel) {
        return MapperUtils.modelToInteger(userModel);
    }

    default AchievementModel achievementToModel(Integer achievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integerToModel(achievement, AchievementModel.class, context);
    }

    default Integer achievementModelToId(AchievementModel achievementModel) {
        return MapperUtils.modelToInteger(achievementModel);
    }

}
