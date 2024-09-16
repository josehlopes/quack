package com.thigas.quack.adapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;

import java.time.LocalDate;

@Mapper(uses = { UserMapper.class, RoadmapMapper.class })
public interface UserRoadmapMapper {

    UserRoadmapMapper INSTANCE = Mappers.getMapper(UserRoadmapMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "roadmap.id", target = "roadmapId")
    @Mapping(source = "progress", target = "progress")
    @Mapping(source = "startedAt", target = "startedAt")
    @Mapping(source = "finishedAt", target = "finishedAt")
    UserRoadmapDTO EntityToDto(UserRoadmapEntity roadmapUserEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roadmapId", target = "roadmap.id")
    @Mapping(source = "progress", target = "progress")
    @Mapping(source = "startedAt", target = "startedAt")
    @Mapping(source = "finishedAt", target = "finishedAt")
    UserRoadmapEntity DtoToEntity(UserRoadmapDTO roadmapUserDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "roadmap.id", target = "roadmapId")
    @Mapping(source = "progress", target = "progress")
    @Mapping(source = "startedAt", target = "startedAt")
    @Mapping(source = "finishedAt", target = "finishedAt")
    UserRoadmapModel EntityToModel(UserRoadmapEntity userEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roadmapId", target = "roadmap.id")
    @Mapping(source = "progress", target = "progress")
    @Mapping(source = "startedAt", target = "startedAt")
    @Mapping(source = "finishedAt", target = "finishedAt")
    UserRoadmapEntity ModelToEntity(UserRoadmapModel userModel);

    default LocalDate localDateToString(String date) {
        if (date == null) {
            return null;
        }
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }

    default String stringToOffSet(LocalDate date) {
        if (date == null) {
            return null;
        }
        String localDate = date.toString();
        return localDate;
    }

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
