package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T00:43:18-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserAchievementMapperImpl implements UserAchievementMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AchievementMapper achievementMapper;
    private final DateTimeFormatter dateTimeFormatter_yyyy_MM_dd_0159776256 = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    @Override
    public UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementDTO userAchievementDTO = new UserAchievementDTO();

        userAchievementDTO.setUser( userAchievementEntityUserId( userAchievementEntity ) );
        userAchievementDTO.setAchievement( userAchievementEntityAchievementId( userAchievementEntity ) );
        if ( userAchievementEntity.getEarnedAt() != null ) {
            userAchievementDTO.setEarnedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( userAchievementEntity.getEarnedAt() ) );
        }
        userAchievementDTO.setId( userAchievementEntity.getId() );

        return userAchievementDTO;
    }

    @Override
    public UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();

        userAchievementEntity.setUser( userAchievementDTOToUserEntity( userAchievementDTO ) );
        userAchievementEntity.setAchievement( userAchievementDTOToAchievementEntity( userAchievementDTO ) );
        if ( userAchievementDTO.getEarnedAt() != null ) {
            userAchievementEntity.setEarnedAt( LocalDate.parse( userAchievementDTO.getEarnedAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        userAchievementEntity.setId( userAchievementDTO.getId() );

        return userAchievementEntity;
    }

    @Override
    public UserAchievementModel entityToModel(UserAchievementEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setId( userEntity.getId() );
        userAchievementModel.setUser( userMapper.entityToModel( userEntity.getUser() ) );
        userAchievementModel.setAchievement( achievementMapper.entityToModel( userEntity.getAchievement() ) );
        userAchievementModel.setEarnedAt( userEntity.getEarnedAt() );

        return userAchievementModel;
    }

    @Override
    public UserAchievementEntity modelToEntity(UserAchievementModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();

        userAchievementEntity.setId( userModel.getId() );
        userAchievementEntity.setUser( userMapper.modelToEntity( userModel.getUser() ) );
        userAchievementEntity.setAchievement( achievementMapper.modelToEntity( userModel.getAchievement() ) );
        userAchievementEntity.setEarnedAt( userModel.getEarnedAt() );

        return userAchievementEntity;
    }

    @Override
    public UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setUser( userAchievementDTOToUserModel( userAchievementDTO ) );
        userAchievementModel.setAchievement( userAchievementDTOToAchievementModel( userAchievementDTO ) );
        if ( userAchievementDTO.getEarnedAt() != null ) {
            userAchievementModel.setEarnedAt( LocalDate.parse( userAchievementDTO.getEarnedAt(), dateTimeFormatter_yyyy_MM_dd_0159776256 ) );
        }
        userAchievementModel.setId( userAchievementDTO.getId() );

        return userAchievementModel;
    }

    @Override
    public UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel) {
        if ( userAchievementModel == null ) {
            return null;
        }

        UserAchievementDTO userAchievementDTO = new UserAchievementDTO();

        userAchievementDTO.setUser( userAchievementModelUserId( userAchievementModel ) );
        userAchievementDTO.setAchievement( userAchievementModelAchievementId( userAchievementModel ) );
        if ( userAchievementModel.getEarnedAt() != null ) {
            userAchievementDTO.setEarnedAt( dateTimeFormatter_yyyy_MM_dd_0159776256.format( userAchievementModel.getEarnedAt() ) );
        }
        userAchievementDTO.setId( userAchievementModel.getId() );

        return userAchievementDTO;
    }

    private int userAchievementEntityUserId(UserAchievementEntity userAchievementEntity) {
        if ( userAchievementEntity == null ) {
            return 0;
        }
        UserEntity user = userAchievementEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userAchievementEntityAchievementId(UserAchievementEntity userAchievementEntity) {
        if ( userAchievementEntity == null ) {
            return 0;
        }
        AchievementEntity achievement = userAchievementEntity.getAchievement();
        if ( achievement == null ) {
            return 0;
        }
        int id = achievement.getId();
        return id;
    }

    protected UserEntity userAchievementDTOToUserEntity(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userAchievementDTO.getUser() );

        return userEntity;
    }

    protected AchievementEntity userAchievementDTOToAchievementEntity(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( userAchievementDTO.getAchievement() );

        return achievementEntity;
    }

    protected UserModel userAchievementDTOToUserModel(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userAchievementDTO.getUser() );

        return userModel;
    }

    protected AchievementModel userAchievementDTOToAchievementModel(UserAchievementDTO userAchievementDTO) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( userAchievementDTO.getAchievement() );

        return achievementModel;
    }

    private int userAchievementModelUserId(UserAchievementModel userAchievementModel) {
        if ( userAchievementModel == null ) {
            return 0;
        }
        UserModel user = userAchievementModel.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    private int userAchievementModelAchievementId(UserAchievementModel userAchievementModel) {
        if ( userAchievementModel == null ) {
            return 0;
        }
        AchievementModel achievement = userAchievementModel.getAchievement();
        if ( achievement == null ) {
            return 0;
        }
        int id = achievement.getId();
        return id;
    }
}
