package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsMapper INSTANCE = Mappers.getMapper(StatisticsMapper.class);

    @Mapping(source = "user.id", target = "userId")
    StatisticsDTO entityToDto(StatisticsEntity statistics);

    @Mapping(source = "userId", target = "user.id")
    StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO);

    @Mapping(source = "user.id", target = "user")
    StatisticsModel entityToModel(StatisticsEntity statistics);

    @Mapping(source = "user.id", target = "user.id")
    StatisticsEntity modelToEntity(StatisticsModel statisticsModel);

    default UserModel map(Integer userId) {
        if (userId == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        return userModel;
    }

    default Integer map(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }
}
