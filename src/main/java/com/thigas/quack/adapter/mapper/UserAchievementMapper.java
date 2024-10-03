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
import java.util.Set;

@Mapper(uses = {UserMapper.class, AchievementMapper.class}, componentModel = "spring")
public interface UserAchievementMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd"),
    })
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd"),
    })
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({
            @Mapping(target = "achievement", source = "achievement"),
            @Mapping(target = "user", source = "user")})
    UserAchievementModel entityToModel(UserAchievementEntity userEntity, @Context CycleAvoidingMappingContext context);

@Mappings({
        @Mapping(target = "achievement", source = "achievement"),
        @Mapping(target = "user", source = "user")})
    UserAchievementEntity modelToEntity(UserAchievementModel userModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd"),
    })
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "earnedAt", target = "earnedAt", dateFormat = "yyyy-MM-dd"),
    })
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    default Set<UserModel> userToModel(Set<Integer> user, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(user, UserModel.class, context);
    }

    default Set<Integer> userModelToId(Set<UserModel> userModel) {
        return MapperUtils.modelsToIntegers(userModel);
    }

    default Set<AchievementModel> achievementToModel(Set<Integer> achievement, @Context CycleAvoidingMappingContext context) {
        return MapperUtils.integersToModels(achievement, AchievementModel.class, context);
    }

    default Set<Integer> achievementModelToId(Set<AchievementModel> achievementModel) {
        return MapperUtils.modelsToIntegers(achievementModel);
    }

}
