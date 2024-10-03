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
    date = "2024-10-03T01:18:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserRoadmapMapperImpl implements UserRoadmapMapper {

    @Override
    public UserRoadmapDTO entityToDto(UserRoadmapEntity userRoadmapEntity, CycleAvoidingMappingContext context) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapEntityUserId( userRoadmapEntity ) );
        userRoadmapDTO.setRoadmap( userRoadmapEntityRoadmapId( userRoadmapEntity ) );
        userRoadmapDTO.setStatus( userRoadmapMapStatusToInteger( userRoadmapEntity.getStatus() ) );
        userRoadmapDTO.setId( userRoadmapEntity.getId() );
        userRoadmapDTO.setProgress( userRoadmapEntity.getProgress() );
        if ( userRoadmapEntity.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getStartedAt() ) );
        }
        if ( userRoadmapEntity.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapEntity.getFinishedAt() ) );
        }

        return userRoadmapDTO;
    }

    @Override
    public UserRoadmapEntity dtoToEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapDTOToUserEntity( userRoadmapDTO, context ) );
        userRoadmapEntity.setRoadmap( userRoadmapDTOToRoadmapEntity( userRoadmapDTO, context ) );
        userRoadmapEntity.setStatus( userRoadmapMapIntegerToStatus( userRoadmapDTO.getStatus() ) );
        userRoadmapEntity.setId( userRoadmapDTO.getId() );
        userRoadmapEntity.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapEntity.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapEntity.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel entityToModel(UserRoadmapEntity userRoadmapEntity, CycleAvoidingMappingContext context) {
        if ( userRoadmapEntity == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( userRoadmapIntegerToModel( userRoadmapEntityUserId1( userRoadmapEntity ), context ) );
        userRoadmapModel.setRoadmap( roadmapIntegerToModel( userRoadmapEntityRoadmapId1( userRoadmapEntity ), context ) );
        userRoadmapModel.setId( userRoadmapEntity.getId() );
        userRoadmapModel.setProgress( userRoadmapEntity.getProgress() );
        userRoadmapModel.setStartedAt( userRoadmapEntity.getStartedAt() );
        userRoadmapModel.setFinishedAt( userRoadmapEntity.getFinishedAt() );
        userRoadmapModel.setStatus( userRoadmapEntity.getStatus() );

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapEntity modelToEntity(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapEntity userRoadmapEntity = new UserRoadmapEntity();

        userRoadmapEntity.setUser( userRoadmapModelToUserEntity( userRoadmapModel, context ) );
        userRoadmapEntity.setRoadmap( userRoadmapModelToRoadmapEntity( userRoadmapModel, context ) );
        userRoadmapEntity.setId( userRoadmapModel.getId() );
        userRoadmapEntity.setProgress( userRoadmapModel.getProgress() );
        userRoadmapEntity.setStartedAt( userRoadmapModel.getStartedAt() );
        userRoadmapEntity.setFinishedAt( userRoadmapModel.getFinishedAt() );
        userRoadmapEntity.setStatus( userRoadmapModel.getStatus() );

        return userRoadmapEntity;
    }

    @Override
    public UserRoadmapModel dtoToModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserRoadmapModel userRoadmapModel = new UserRoadmapModel();

        userRoadmapModel.setUser( userRoadmapDTOToUserModel( userRoadmapDTO, context ) );
        userRoadmapModel.setRoadmap( userRoadmapDTOToRoadmapModel( userRoadmapDTO, context ) );
        userRoadmapModel.setStatus( userRoadmapMapIntegerToStatus( userRoadmapDTO.getStatus() ) );
        userRoadmapModel.setId( userRoadmapDTO.getId() );
        userRoadmapModel.setProgress( userRoadmapDTO.getProgress() );
        if ( userRoadmapDTO.getStartedAt() != null ) {
            userRoadmapModel.setStartedAt( LocalDate.parse( userRoadmapDTO.getStartedAt() ) );
        }
        if ( userRoadmapDTO.getFinishedAt() != null ) {
            userRoadmapModel.setFinishedAt( LocalDate.parse( userRoadmapDTO.getFinishedAt() ) );
        }

        return userRoadmapModel;
    }

    @Override
    public UserRoadmapDTO modelToDto(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserRoadmapDTO userRoadmapDTO = new UserRoadmapDTO();

        userRoadmapDTO.setUser( userRoadmapModelUserId( userRoadmapModel ) );
        userRoadmapDTO.setRoadmap( userRoadmapModelRoadmapId( userRoadmapModel ) );
        userRoadmapDTO.setStatus( userRoadmapMapStatusToInteger( userRoadmapModel.getStatus() ) );
        userRoadmapDTO.setId( userRoadmapModel.getId() );
        userRoadmapDTO.setProgress( userRoadmapModel.getProgress() );
        if ( userRoadmapModel.getStartedAt() != null ) {
            userRoadmapDTO.setStartedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getStartedAt() ) );
        }
        if ( userRoadmapModel.getFinishedAt() != null ) {
            userRoadmapDTO.setFinishedAt( DateTimeFormatter.ISO_LOCAL_DATE.format( userRoadmapModel.getFinishedAt() ) );
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

    protected UserEntity userRoadmapDTOToUserEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userRoadmapDTO.getUser() );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapDTOToRoadmapEntity(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
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

    protected UserEntity userRoadmapModelToUserEntity(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userRoadmapModelToInteger( userRoadmapModel.getUser() ) );

        return userEntity;
    }

    protected RoadmapEntity userRoadmapModelToRoadmapEntity(UserRoadmapModel userRoadmapModel, CycleAvoidingMappingContext context) {
        if ( userRoadmapModel == null ) {
            return null;
        }

        RoadmapEntity roadmapEntity = new RoadmapEntity();

        roadmapEntity.setId( roadmapModelToInteger( userRoadmapModel.getRoadmap() ) );

        return roadmapEntity;
    }

    protected UserModel userRoadmapDTOToUserModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
        if ( userRoadmapDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userRoadmapDTO.getUser() );

        return userModel;
    }

    protected RoadmapModel userRoadmapDTOToRoadmapModel(UserRoadmapDTO userRoadmapDTO, CycleAvoidingMappingContext context) {
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
