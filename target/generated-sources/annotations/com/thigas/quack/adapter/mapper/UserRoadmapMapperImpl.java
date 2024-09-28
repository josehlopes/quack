package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserRoadmapDTO;
import com.thigas.quack.domain.entity.RoadmapEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.domain.entity.UserRoadmapEntity;
import com.thigas.quack.infrastructure.persistence.entity.RoadmapModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import com.thigas.quack.infrastructure.persistence.entity.UserRoadmapModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-28T12:33:20-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Override
    public UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapEntityUserId( userRoadmapEntity ) );
        userRoadmapDTO.setRoadmap( userRoadmapEntityRoadmapId( userRoadmapEntity ) );
        userRoadmapDTO.setStatus( statusToInt( userRoadmapEntity.getStatus() ) );
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
    public UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapDTOToUserEntity( userRoadmapDTO ) );
        userRoadmapEntity.setRoadmap( userRoadmapDTOToRoadmapEntity( userRoadmapDTO ) );
        userRoadmapEntity.setStatus( intToStatus( userRoadmapDTO.getStatus() ) );
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
    public UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( map( userRoadmapEntityUserId1( userRoadmapEntity ) ) );
        userRoadmapModel.setRoadmap( mapRoadmap( userRoadmapEntityRoadmapId1( userRoadmapEntity ) ) );
        userRoadmapModel.setFinishedAt( userRoadmapEntity.getFinishedAt() );
        userRoadmapModel.setId( userRoadmapEntity.getId() );
        userRoadmapModel.setProgress( userRoadmapEntity.getProgress() );
        userRoadmapModel.setStartedAt( userRoadmapEntity.getStartedAt() );
        userRoadmapModel.setStatus( userRoadmapEntity.getStatus() );

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel) {
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
        userRoadmapEntity.setStatus( userRoadmapModel.getStatus() );

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( userRoadmapDTOToUserModel( userRoadmapDTO ) );
        userRoadmapModel.setRoadmap( userRoadmapDTOToRoadmapModel( userRoadmapDTO ) );
        userRoadmapModel.setStatus( intToStatus( userRoadmapDTO.getStatus() ) );
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapModel.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }
        userRoadmapModel.setId( userRoadmapDTO.getId() );
        userRoadmapModel.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapModel.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapModelUserId( userRoadmapModel ) );
        userRoadmapDTO.setRoadmap( userRoadmapModelRoadmapId( userRoadmapModel ) );
        userRoadmapDTO.setStatus( statusToInt( userRoadmapModel.getStatus() ) );
        if ( userRoadmapModel.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getFinishedAt() ) );
        }
        userRoadmapDTO.setId( userRoadmapModel.getId() );
        userRoadmapDTO.setProgress( userRoadmapModel.getProgress() );
        if ( userRoadmapModel.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getStartedAt() ) );
        }

        return userRoadmapDTO;
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

        userEntity.setId( userRoadmapDTO.getUser() );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapDTOToRoadmapEntity(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( userRoadmapDTO.getRoadmap() );

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

        userEntity.setId( map( userRoadmapModel.getUser() ) );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapModelToRoadmapEntity(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( map( userRoadmapModel.getRoadmap() ) );

        return roadmapEntity;
    }

    protected UserModel userRoadmapDTOToUserModel(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userRoadmapDTO.getUser() );

        return userModel;
    }

    protected RoadmapModel userRoadmapDTOToRoadmapModel(UserRoadmapDTO userRoadmapDTO) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        RoadmapModel roadmapModel = new RoadmapModel();

        roadmapModel.setId( userRoadmapDTO.getRoadmap() );

        return roadmapModel;
    }

    private int userRoadmapModelUserId(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return 0;
        }
        UserModel user = userRoadmapModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userRoadmapModelRoadmapId(UserRoadmapModel userRoadmapModel) {
        if ( userRoadmapModel == null ) {
            return 0;
        }
        RoadmapModel roadmap = userRoadmapModel.getRoadmap();
        if ( roadmap == null ) {
            return 0;
        }
        int id = roadmap.getId();
        return id;
    }
}
