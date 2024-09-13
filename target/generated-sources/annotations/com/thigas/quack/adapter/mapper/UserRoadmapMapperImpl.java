package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T17:44:56-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Override
    public UserRoadmapDTO EntityToDto(UserRoadmapEntity roadmapUserEntity) {
        if ( roadmapUserEntity == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUserId( roadmapUserEntityUserId( roadmapUserEntity ) );
        userRoadmapDTO.setRoadmapId( roadmapUserEntityRoadmapId( roadmapUserEntity ) );
        userRoadmapDTO.setProgress( roadmapUserEntity.getProgress() );
        userRoadmapDTO.setStartedAt( stringToOffSet( roadmapUserEntity.getStartedAt() ) );
        userRoadmapDTO.setFinishedAt( stringToOffSet( roadmapUserEntity.getFinishedAt() ) );
        userRoadmapDTO.setId( roadmapUserEntity.getId() );

        return userRoadmapDTO;
    }

    @Override
    public UserRoadmapEntity DtoToEntity(UserRoadmapDTO roadmapUserDTO) {
        if ( roadmapUserDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapDTOToUserEntity( roadmapUserDTO ) );
        userRoadmapEntity.setRoadmap( userRoadmapDTOToRoadmapEntity( roadmapUserDTO ) );
        userRoadmapEntity.setProgress( roadmapUserDTO.getProgress() );
        userRoadmapEntity.setStartedAt( localDateToString( roadmapUserDTO.getStartedAt() ) );
        userRoadmapEntity.setFinishedAt( localDateToString( roadmapUserDTO.getFinishedAt() ) );
        userRoadmapEntity.setId( roadmapUserDTO.getId() );

        return userRoadmapEntity;
    }

    private int roadmapUserEntityUserId(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return 0;
        }
        UserEntity user = userRoadmapEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int roadmapUserEntityRoadmapId(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return 0;
        }
        RoadmapEntity roadmap = userRoadmapEntity.getRoadmap();
        if ( roadmap == null ) {
            return 0;
        }
        int id = roadmap.getId();
        return id;
    }

    protected UserEntity userRoadmapDTOToUserEntity(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userRoadmapDTO.getUserId() );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapDTOToRoadmapEntity(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( userRoadmapDTO.getRoadmapId() );

        return roadmapEntity;
    }
}
