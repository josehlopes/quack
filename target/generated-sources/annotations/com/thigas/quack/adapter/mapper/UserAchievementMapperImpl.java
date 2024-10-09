package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.UserAchievementDTO;
import com.thigas.quack.domain.entity.AchievementEntity;
import com.thigas.quack.domain.entity.UserAchievementEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.AchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserAchievementModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UserAchievementMapperImpl implements UserAchievementMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, CycleAvoidingMappingContext context) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementDTO userAchievementDTO = new UserAchievementDTO();

        userAchievementDTO.setUser( userAchievementEntityUserId( userAchievementEntity ) );
        userAchievementDTO.setAchievement( userAchievementEntityAchievementId( userAchievementEntity ) );
        userAchievementDTO.setId( userAchievementEntity.getId() );
        userAchievementDTO.setImagePath( userAchievementEntity.getImagePath() );
        userAchievementDTO.setObtainedDate( userMapper.stringToOffSet( userAchievementEntity.getObtainedDate() ) );

        return userAchievementDTO;
    }

    @Override
    public UserAchievementEntity dtoToEntity(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();

        userAchievementEntity.setUser( userAchievementDTOToUserEntity( userAchievementDTO, context ) );
        userAchievementEntity.setAchievement( userAchievementDTOToAchievementEntity( userAchievementDTO, context ) );
        userAchievementEntity.setId( userAchievementDTO.getId() );
        userAchievementEntity.setImagePath( userAchievementDTO.getImagePath() );
        userAchievementEntity.setObtainedDate( userMapper.offSetToString( userAchievementDTO.getObtainedDate() ) );

        return userAchievementEntity;
    }

    @Override
    public UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, CycleAvoidingMappingContext context) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setId( userAchievementEntity.getId() );
        userAchievementModel.setUser( userMapper.entityToModel( userAchievementEntity.getUser(), context ) );
        userAchievementModel.setAchievement( achievementMapper.entityToModel( userAchievementEntity.getAchievement(), context ) );
        userAchievementModel.setImagePath( userAchievementEntity.getImagePath() );
        userAchievementModel.setObtainedDate( userAchievementEntity.getObtainedDate() );

        return userAchievementModel;
    }

    @Override
    public UserAchievementEntity modelToEntity(UserAchievementModel userAchievementModel, CycleAvoidingMappingContext context) {
        if ( userAchievementModel == null ) {
            return null;
        }

        UserAchievementEntity userAchievementEntity = new UserAchievementEntity();

        userAchievementEntity.setId( userAchievementModel.getId() );
        userAchievementEntity.setUser( userMapper.modelToEntity( userAchievementModel.getUser(), context ) );
        userAchievementEntity.setAchievement( achievementMapper.modelToEntity( userAchievementModel.getAchievement(), context ) );
        userAchievementEntity.setImagePath( userAchievementModel.getImagePath() );
        userAchievementEntity.setObtainedDate( userAchievementModel.getObtainedDate() );

        return userAchievementEntity;
    }

    @Override
    public UserAchievementDTO modelToDto(UserAchievementModel userAchievementModel, CycleAvoidingMappingContext context) {
        if ( userAchievementModel == null ) {
            return null;
        }

        UserAchievementDTO userAchievementDTO = new UserAchievementDTO();

        userAchievementDTO.setUser( userAchievementModelUserId( userAchievementModel ) );
        userAchievementDTO.setAchievement( userAchievementModelAchievementId( userAchievementModel ) );
        userAchievementDTO.setId( userAchievementModel.getId() );
        userAchievementDTO.setImagePath( userAchievementModel.getImagePath() );
        userAchievementDTO.setObtainedDate( userMapper.stringToOffSet( userAchievementModel.getObtainedDate() ) );

        return userAchievementDTO;
    }

    @Override
    public UserAchievementModel dtoToModel(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setUser( userAchievementDTOToUserModel( userAchievementDTO, context ) );
        userAchievementModel.setAchievement( userAchievementDTOToAchievementModel( userAchievementDTO, context ) );
        userAchievementModel.setId( userAchievementDTO.getId() );
        userAchievementModel.setImagePath( userAchievementDTO.getImagePath() );
        userAchievementModel.setObtainedDate( userMapper.offSetToString( userAchievementDTO.getObtainedDate() ) );

        return userAchievementModel;
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

    protected UserEntity userAchievementDTOToUserEntity(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userAchievementDTO.getUser() );

        return userEntity;
    }

    protected AchievementEntity userAchievementDTOToAchievementEntity(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( userAchievementDTO.getAchievement() );

        return achievementEntity;
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

    protected UserModel userAchievementDTOToUserModel(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userAchievementDTO.getUser() );

        return userModel;
    }

    protected AchievementModel userAchievementDTOToAchievementModel(UserAchievementDTO userAchievementDTO, CycleAvoidingMappingContext context) {
        if ( userAchievementDTO == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( userAchievementDTO.getAchievement() );

        return achievementModel;
    }
}
