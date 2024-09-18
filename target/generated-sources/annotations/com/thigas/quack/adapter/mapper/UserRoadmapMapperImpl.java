package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-18T11:57:35-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Override
    public UserRoadmapDTO EntityToDto(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUserId( userRoadmapEntityUserId( userRoadmapEntity ) );
        userRoadmapDTO.setRoadmapId( userRoadmapEntityRoadmapId( userRoadmapEntity ) );
        if ( userRoadmapEntity.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getFinishedAt() ) );
        }
        userRoadmapDTO.setId( userRoadmapEntity.getId() );
        userRoadmapDTO.setProgress( userRoadmapEntity.getProgress() );
        if ( userRoadmapEntity.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getStartedAt() ) );
        }

        return userRoadmapDTO;
    }

    @Override
    public UserRoadmapEntity DtoToEntity(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapDTOToUserEntity( userRoadmapDTO ) );
        userRoadmapEntity.setRoadmap( userRoadmapDTOToRoadmapEntity( userRoadmapDTO ) );
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapEntity.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }
        userRoadmapEntity.setId( userRoadmapDTO.getId() );
        userRoadmapEntity.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapEntity.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel EntityToModel(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUserId( map( userRoadmapEntityUserId1( userRoadmapEntity ) ) );
        userRoadmapModel.setRoadmapId( mapRoadmap( userRoadmapEntityRoadmapId1( userRoadmapEntity ) ) );
        userRoadmapModel.setFinishedAt( userRoadmapEntity.getFinishedAt() );
        userRoadmapModel.setId( userRoadmapEntity.getId() );
        userRoadmapModel.setProgress( userRoadmapEntity.getProgress() );
        userRoadmapModel.setStartedAt( userRoadmapEntity.getStartedAt() );

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapEntity ModelToEntity(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapModelToUserEntity( userRoadmapModel ) );
        userRoadmapEntity.setRoadmap( userRoadmapModelToRoadmapEntity( userRoadmapModel ) );
        userRoadmapEntity.setFinishedAt( userRoadmapModel.getFinishedAt() );
        userRoadmapEntity.setId( userRoadmapModel.getId() );
        userRoadmapEntity.setProgress( userRoadmapModel.getProgress() );
        userRoadmapEntity.setStartedAt( userRoadmapModel.getStartedAt() );

        return userRoadmapEntity;
    }

    private int userRoadmapEntityUserId(UserRoadmapEntity userRoadmapEntity) {
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

    private int userRoadmapEntityRoadmapId(UserRoadmapEntity userRoadmapEntity) {
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

    private Integer userRoadmapEntityUserId1(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }
        UserEntity user = userRoadmapEntity.getUser();
        if ( user == null ) {
            return null;
        }
        int id = user.getId();
        return id;
    }

    private Integer userRoadmapEntityRoadmapId1(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }
        RoadmapEntity roadmap = userRoadmapEntity.getRoadmap();
        if ( roadmap == null ) {
            return null;
        }
        int id = roadmap.getId();
        return id;
    }

    protected UserEntity userRoadmapModelToUserEntity(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( map( userRoadmapModel.getUserId() ) );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapModelToRoadmapEntity(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( map( userRoadmapModel.getRoadmapId() ) );

        return roadmapEntity;
    }
}
