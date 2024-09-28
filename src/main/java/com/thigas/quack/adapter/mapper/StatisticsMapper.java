package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatisticsMapper {

    StatisticsMapper INSTANCE = Mappers.getMapper(StatisticsMapper.class);

    @Mapping(source = "user.id", target = "user")
    StatisticsDTO entityToDto(StatisticsEntity statistics);

    @Mapping(source = "user", target = "user.id")
    StatisticsEntity dtoToEntity(StatisticsDTO statisticsDTO);

    @Mapping(source = "user.id", target = "user")
    StatisticsModel entityToModel(StatisticsEntity statistics);

    @Mapping(source = "user.id", target = "user.id")
    StatisticsEntity modelToEntity(StatisticsModel statisticsModel);

    @Mapping(source = "user", target = "user.id")
    StatisticsModel dtoToModel(StatisticsDTO statisticsDTO);

    @Mapping(source = "user.id", target = "user")
    StatisticsDTO modelToDto(StatisticsModel statisticsModel);

    default UserModel map(Integer user) {
        if (user == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        userModel.setId(user);
        return userModel;
    }

    default Integer map(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        return userModel.getId();
    }

    default Status map(int value) {
        return Status.fromValue(value);
    }

    default int map(Status status) {
        return status.getValue();
    }
}
