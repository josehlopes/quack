package com.thigas.quack.adapter.mapper;

import com.thigas.quack.adapter.dto.StatisticsDTO;
import com.thigas.quack.domain.entity.StatisticsEntity;
import com.thigas.quack.domain.entity.UserEntity;
import com.thigas.quack.infrastructure.persistence.entity.StatisticsModel;
import com.thigas.quack.infrastructure.persistence.entity.UserModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-13T15:28:57-0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.39.0.v20240820-0604, environment: Java 17.0.12 (Eclipse Adoptium)"
)
public class StatisticsMapperImpl implements StatisticsMapper {

    @Override
    public StatisticsDTO EntityToDto(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsDTO statisticsDTO = new StatisticsDTO();

        statisticsDTO.setUserId( statisticsUserId( statistics ) );
        statisticsDTO.setId( statistics.getId() );
        statisticsDTO.setStreakDays( statistics.getStreakDays() );
        statisticsDTO.setBestStreak( statistics.getBestStreak() );
        statisticsDTO.setUserLevel( statistics.getUserLevel() );
        statisticsDTO.setUserExperience( statistics.getUserExperience() );
        statisticsDTO.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsDTO.setLessonsCompleted( statistics.getLessonsCompleted() );

        return statisticsDTO;
    }

    @Override
    public StatisticsEntity DtoToEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( statisticsDTOToUserEntity( statisticsDTO ) );
        statisticsEntity.setId( statisticsDTO.getId() );
        statisticsEntity.setStreakDays( statisticsDTO.getStreakDays() );
        statisticsEntity.setBestStreak( statisticsDTO.getBestStreak() );
        statisticsEntity.setUserLevel( statisticsDTO.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsDTO.getUserExperience() );
        statisticsEntity.setChallengesCompleted( statisticsDTO.getChallengesCompleted() );
        statisticsEntity.setLessonsCompleted( statisticsDTO.getLessonsCompleted() );

        return statisticsEntity;
    }

    @Override
    public StatisticsModel EntityToModel(StatisticsEntity statistics) {
        if ( statistics == null ) {
            return null;
        }

        StatisticsModel statisticsModel = new StatisticsModel();

        statisticsModel.setUser( userEntityToUserModel( statistics.getUser() ) );
        statisticsModel.setId( statistics.getId() );
        statisticsModel.setstreakDays( statistics.getStreakDays() );
        statisticsModel.setbestStreak( statistics.getBestStreak() );
        statisticsModel.setUserLevel( statistics.getUserLevel() );
        statisticsModel.setUserExperience( statistics.getUserExperience() );
        statisticsModel.setChallengesCompleted( statistics.getChallengesCompleted() );
        statisticsModel.setLessonsCompleted( statistics.getLessonsCompleted() );

        return statisticsModel;
    }

    @Override
    public StatisticsEntity ModelToEntity(StatisticsModel statisticsModel) {
        if ( statisticsModel == null ) {
            return null;
        }

        StatisticsEntity statisticsEntity = new StatisticsEntity();

        statisticsEntity.setUser( userModelToUserEntity( statisticsModel.getUser() ) );
        statisticsEntity.setId( statisticsModel.getId() );
        statisticsEntity.setStreakDays( statisticsModel.getstreakDays() );
        statisticsEntity.setBestStreak( statisticsModel.getbestStreak() );
        statisticsEntity.setUserLevel( statisticsModel.getUserLevel() );
        statisticsEntity.setUserExperience( statisticsModel.getUserExperience() );
        statisticsEntity.setChallengesCompleted( statisticsModel.getChallengesCompleted() );
        statisticsEntity.setLessonsCompleted( statisticsModel.getLessonsCompleted() );

        return statisticsEntity;
    }

    private int statisticsUserId(StatisticsEntity statisticsEntity) {
        if ( statisticsEntity == null ) {
            return 0;
        }
        UserEntity user = statisticsEntity.getUser();
        if ( user == null ) {
            return 0;
        }
        int id = user.getId();
        return id;
    }

    protected UserEntity statisticsDTOToUserEntity(StatisticsDTO statisticsDTO) {
        if ( statisticsDTO == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( statisticsDTO.getUserId() );

        return userEntity;
    }

    protected UserModel userEntityToUserModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setId( userEntity.getId() );
        userModel.setName( userEntity.getName() );
        userModel.setPhone( userEntity.getPhone() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setCpf( userEntity.getCpf() );
        userModel.setBornAt( userEntity.getBornAt() );
        userModel.setPoints( userEntity.getPoints() );
        userModel.setRegisterAt( userEntity.getRegisterAt() );
        userModel.setImagePath( userEntity.getImagePath() );

        return userModel;
    }

    protected UserEntity userModelToUserEntity(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userModel.getId() );
        userEntity.setName( userModel.getName() );
        userEntity.setPhone( userModel.getPhone() );
        userEntity.setEmail( userModel.getEmail() );
        userEntity.setPassword( userModel.getPassword() );
        userEntity.setCpf( userModel.getCpf() );
        userEntity.setBornAt( userModel.getBornAt() );
        userEntity.setPoints( userModel.getPoints() );
        userEntity.setRegisterAt( userModel.getRegisterAt() );
        userEntity.setImagePath( userModel.getImagePath() );

        return userEntity;
    }
}
