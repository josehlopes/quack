package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.domain.model.Status;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(uses = {UserMapper.class, RoadmapMapper.class}, componentModel = "spring")
public interface UserRoadmapMapper {

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "roadmap.id", target = "roadmap")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapStatusToInt")
    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "roadmap", target = "roadmap.id")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapIntToStatus")
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "roadmap.id", target = "roadmap")
    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "roadmap", target = "roadmap.id")
    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel);

    @Mapping(source = "user", target = "user.id")
    @Mapping(source = "roadmap", target = "roadmap.id")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapIntToStatus")
    UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO);

    @Mapping(source = "user.id", target = "user")
    @Mapping(source = "roadmap.id", target = "roadmap")
    @Mapping(target = "status", source = "status", qualifiedByName = "userRoadmapStatusToInt")
    UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel);

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

    default RoadmapModel mapRoadmap(Integer roadmap) {
        if (roadmap == null) {
            return null;
        }
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmap);
        return roadmapModel;
    }

    default Integer map(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            return null;
        }
        return roadmapModel.getId();
    }

    @Named("userRoadmapStatusToInt")
    default int statusToInt(Status status) {
        return status != null ? status.getValue() : 0;
    }

    @Named("userRoadmapIntToStatus")
    default Status intToStatus(int value) {
        return Status.fromValue(value);
    }
}
