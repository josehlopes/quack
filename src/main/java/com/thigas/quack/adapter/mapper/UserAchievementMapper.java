package com.thigas.quack.adapter.mapper;


import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {DefaultMapper.class})
public interface UserAchievementMapper {

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "obtainedDate", target = "obtainedDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "offsetDateTimeToString")})
    UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "obtainedDate", target = "obtainedDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "stringToOffsetDateTime")})
    UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

    UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, @Context CycleAvoidingMappingContext context);

    UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user.id", target = "user"),
            @Mapping(source = "achievement.id", target = "achievement"),
            @Mapping(source = "obtainedDate", target = "obtainedDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "offsetDateTimeToString")})
    UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, @Context CycleAvoidingMappingContext context);

    @Mappings({@Mapping(source = "user", target = "user.id"),
            @Mapping(source = "achievement", target = "achievement.id"),
            @Mapping(source = "obtainedDate", target = "obtainedDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss", qualifiedByName = "stringToOffsetDateTime")})
    UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, @Context CycleAvoidingMappingContext context);

}
