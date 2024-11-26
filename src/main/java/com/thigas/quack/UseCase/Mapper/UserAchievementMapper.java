package com.thigas.quack.UseCase.Mapper;

import com.thigas.quack.Adapter.Entity.AddressDataMapper;
import com.thigas.quack.Adapter.Entity.UserAchievementDataMapper;
import com.thigas.quack.Domain.Entity.Interface.Address;
import com.thigas.quack.Domain.Entity.Interface.UserAchievement;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDsRequestModel;
import com.thigas.quack.UseCase.Model.Request.UserAchievementDsRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {MapperDefaults.class})
public interface UserAchievementMapper {

    UserAchievementMapper MAPPER = Mappers.getMapper(UserAchievementMapper.class);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserAchievementDsRequestModel toDsModel(UserAchievement userAchievement);

    @Mappings({
            @Mapping(source = "registerOn", target = "registerOn", dateFormat = "yyyy-MM-dd'T'HH:mm:ssXXX")
    })
    UserAchievementDataMapper toDataMapper(UserAchievementDsRequestModel userAchievementDsRequestModel);

}
