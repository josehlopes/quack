package com.thigas.quack.adapter.mapper;


import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.*;

import java.util.Set;


@Mapper(uses = {MapperUtils.class, UserMapper.class, AchievementMapper.class, UserRoadmapMapper.class}, componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface UserAchievementMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievements", target = "achievements", qualifiedByName = "achievementEntityToInteger")})
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievements", target = "achievements", qualifiedByName = "integerToAchievementEntity")})
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievements", target = "achievements")})
    UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievements", target = "achievements")})
    UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievements", target = "achievements", qualifiedByName = "achievementModelToInteger")})
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievements", target = "achievements", qualifiedByName = "integerToAchievementModel")})
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

}
