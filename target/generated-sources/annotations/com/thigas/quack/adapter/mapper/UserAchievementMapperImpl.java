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
    private DefaultMapper defaultMapper;

    @Override
    public UserAchievementDTO entityToDto(UserAchievementEntity userAchievementEntity, CycleAvoidingMappingContext context) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementDTO userAchievementDTO = new UserAchievementDTO();

        userAchievementDTO.setUser( userAchievementEntityUserId( userAchievementEntity ) );
        userAchievementDTO.setAchievement( userAchievementEntityAchievementId( userAchievementEntity ) );
        userAchievementDTO.setObtainedDate( defaultMapper.stringToOffSet( userAchievementEntity.getObtainedDate() ) );
        userAchievementDTO.setId( userAchievementEntity.getId() );
        userAchievementDTO.setImagePath( userAchievementEntity.getImagePath() );

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
        userAchievementEntity.setObtainedDate( defaultMapper.offSetToString( userAchievementDTO.getObtainedDate() ) );
        userAchievementEntity.setId( userAchievementDTO.getId() );
        userAchievementEntity.setImagePath( userAchievementDTO.getImagePath() );

        return userAchievementEntity;
    }

    @Override
    public UserAchievementModel entityToModel(UserAchievementEntity userAchievementEntity, CycleAvoidingMappingContext context) {
        if ( userAchievementEntity == null ) {
            return null;
        }

        UserAchievementModel userAchievementModel = new UserAchievementModel();

        userAchievementModel.setId( userAchievementEntity.getId() );
        userAchievementModel.setUser( userEntityToUserModel( userAchievementEntity.getUser(), context ) );
        userAchievementModel.setAchievement( achievementEntityToAchievementModel( userAchievementEntity.getAchievement(), context ) );
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
        userAchievementEntity.setUser( userModelToUserEntity( userAchievementModel.getUser(), context ) );
        userAchievementEntity.setAchievement( achievementModelToAchievementEntity( userAchievementModel.getAchievement(), context ) );
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
        userAchievementDTO.setObtainedDate( defaultMapper.stringToOffSet( userAchievementModel.getObtainedDate() ) );
        userAchievementDTO.setId( userAchievementModel.getId() );
        userAchievementDTO.setImagePath( userAchievementModel.getImagePath() );

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
        userAchievementModel.setObtainedDate( defaultMapper.offSetToString( userAchievementDTO.getObtainedDate() ) );
        userAchievementModel.setId( userAchievementDTO.getId() );
        userAchievementModel.setImagePath( userAchievementDTO.getImagePath() );

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

    protected UserModel userEntityToUserModel(UserEntity userEntity, CycleAvoidingMappingContext context) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setUsername( userEntity.getUsername() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setStatus( userEntity.getStatus() );
        userModel.setImagePath( userEntity.getImagePath() );

        return userModel;
    }

    protected AchievementModel achievementEntityToAchievementModel(AchievementEntity achievementEntity, CycleAvoidingMappingContext context) {
        if ( achievementEntity == null ) {
            return null;
        }

        AchievementModel achievementModel = new AchievementModel();

        achievementModel.setId( achievementEntity.getId() );
        achievementModel.setName( achievementEntity.getName() );
        achievementModel.setDescription( achievementEntity.getDescription() );
        achievementModel.setImagePath( achievementEntity.getImagePath() );

        return achievementModel;
    }

    protected UserEntity userModelToUserEntity(UserModel userModel, CycleAvoidingMappingContext context) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setUsername( userModel.getUsername() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setImagePath( userModel.getImagePath() );
        userEntity.setStatus( userModel.getStatus() );

        return userEntity;
    }

    protected AchievementEntity achievementModelToAchievementEntity(AchievementModel achievementModel, CycleAvoidingMappingContext context) {
        if ( achievementModel == null ) {
            return null;
        }

        AchievementEntity achievementEntity = new AchievementEntity();

        achievementEntity.setId( achievementModel.getId() );
        achievementEntity.setName( achievementModel.getName() );
        achievementEntity.setDescription( achievementModel.getDescription() );
        achievementEntity.setImagePath( achievementModel.getImagePath() );

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
