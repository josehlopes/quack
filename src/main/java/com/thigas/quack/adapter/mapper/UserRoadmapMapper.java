package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { UserMapper.class, RoadmapMapper.class }, componentModel = "spring")
public interface UserRoadmapMapper {

    UserRoadmapMapper INSTANCE = Mappers.getMapper(UserRoadmapMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "roadmap.id", target = "roadmapId")
    UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roadmapId", target = "roadmap.id")
    UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "roadmap.id", target = "roadmapId")
    UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roadmapId", target = "roadmap.id")
    UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel);

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

    default RoadmapModel mapRoadmap(Integer roadmapId) {
        if (roadmapId == null) {
            return null;
        }
        RoadmapModel roadmapModel = new RoadmapModel();
        roadmapModel.setId(roadmapId);
        return roadmapModel;
    }

    default Integer map(RoadmapModel roadmapModel) {
        if (roadmapModel == null) {
            return null;
        }
        return roadmapModel.getId();
    }
}
