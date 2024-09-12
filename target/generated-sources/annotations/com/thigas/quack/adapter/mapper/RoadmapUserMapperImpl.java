package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.RoadmapUserDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.RoadmapUserEntity;
import com.thigas.quack.domain.entity.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-12T13:08:34-0300",
    comments = "version: 1.6.0, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class RoadmapUserMapperImpl implements RoadmapUserMapper {

    @Override
    public RoadmapUserDTO toRoadmapUserDTO(RoadmapUserEntity roadmapUserEntity) {
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
    public RoadmapUserEntity toRoadmapUserEntity(RoadmapUserDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        RoadmapUserEntity roadmapUserEntity = new RoadmapUserEntity();

        roadmapUserEntity.setUser( roadmapUserDTOToUserEntity( roadmapUserDTO ) );
        roadmapUserEntity.setRoadmap( roadmapUserDTOToRoadmapEntity( roadmapUserDTO ) );
        roadmapUserEntity.setId( roadmapUserDTO.getId() );

        return roadmapUserEntity;
    }

    private Long roadmapUserEntityUserId(RoadmapUserEntity roadmapUserEntity) {
        UserEntity user = roadmapUserEntity.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private Long roadmapUserEntityRoadmapId(RoadmapUserEntity roadmapUserEntity) {
        RoadmapEntity roadmap = roadmapUserEntity.getRoadmap();
        if ( roadmap == null ) {
            return null;
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
