package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
import com.thigas.quack.Domain.Entity.Interface.UserAchievement;
import com.thigas.quack.UseCase.Model.Request.UserAchievementRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserAchievementMapper {

    UserAchievementMapper MAPPER = Mappers.getMapper(UserAchievementMapper.class);

    @Mappings({
            @Mapping(target = "obtainedOn", source = "obtainedOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserAchievementRequestModel toDsModel(UserAchievement userAchievement);

    @Mappings({
            @Mapping(target = "obtainedOn", source = "obtainedOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX"),
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "achievement.id", source = "achievementId")
    })
    UserAchievementDataMapper toDataMapper(UserAchievementRequestModel userAchievementRequestModel);


    @Mappings({
            @Mapping(target = "obtainedOn", source = "obtainedOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX"),
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "achievementId", source = "achievement.id")
    })
    UserAchievementRequestModel toDsModel(UserAchievementDataMapper userAchievementDataMapper);

}
