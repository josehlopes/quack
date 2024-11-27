package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AchievementDataMapper;
import com.thigas.quack.UseCase.Model.Request.AchievementRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface AchievementMapper {

    AchievementMapper MAPPER = Mappers.getMapper(AchievementMapper.class);

    AchievementRequestModel toDsModel(AchievementDataMapper achievementDataMapper);

}
