package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T00:51:01-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Override
    public RoadmapUserDTO toRoadmapUserDTO(UserRoadmapEntity roadmapUserEntity) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        RoadmapUserDTO roadmapUserDTO = new RoadmapUserDTO();

        roadmapUserDTO.setUserId( roadmapUserEntityUserId( roadmapUserEntity ) );
        roadmapUserDTO.setRoadmapId( roadmapUserEntityRoadmapId( roadmapUserEntity ) );
        roadmapUserDTO.setId( roadmapUserEntity.getId() );

        return roadmapUserDTO;
    }

    @Override
    public UserRoadmapEntity toRoadmapUserEntity(RoadmapUserDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( roadmapUserDTOToUserEntity( roadmapUserDTO ) );
        userRoadmapEntity.setRoadmap( roadmapUserDTOToRoadmapEntity( roadmapUserDTO ) );
        userRoadmapEntity.setId( roadmapUserDTO.getId() );

        return userRoadmapEntity;
    }

    private int roadmapUserEntityUserId(UserRoadmapEntity userRoadmapEntity) {
        UserEntity user = userRoadmapEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        return user.getId();
    }

    private int roadmapUserEntityRoadmapId(UserRoadmapEntity userRoadmapEntity) {
        RoadmapEntity roadmap = userRoadmapEntity.getRoadmap();
        if ( roadmap == null ) {
            return 0;
        }
        return roadmap.getId();
    }

    protected UserEntity roadmapUserDTOToUserEntity(RoadmapUserDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( roadmapUserDTO.getUserId() );

        return userEntity;
    }

    protected RoadmapEntity roadmapUserDTOToRoadmapEntity(RoadmapUserDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapUserDTO.getRoadmapId() );

        return roadmapEntity;
    }
}
