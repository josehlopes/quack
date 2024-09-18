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

    @Mapping(source = "user.id", target = "userId") // user.id do StatisticsModel para userId do StatisticsDTO
    StatisticsDTO EntityToDto(StatisticsEntity statistics);

    @Mapping(source = "userId", target = "user.id") // userId do StatisticsDTO para user.id do StatisticsEntity
    StatisticsEntity DtoToEntity(StatisticsDTO statisticsDTO);

    @Mapping(source = "user.id", target = "user") // user.id do StatisticsEntity para UserModel no StatisticsModel
    StatisticsModel EntityToModel(StatisticsEntity statistics);

    @Mapping(source = "user.id", target = "user.id") // user.id do StatisticsModel para user.id do StatisticsEntity
    StatisticsEntity ModelToEntity(StatisticsModel statisticsModel);

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
